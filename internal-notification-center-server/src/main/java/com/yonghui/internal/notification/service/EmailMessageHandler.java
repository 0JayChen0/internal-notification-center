package com.yonghui.internal.notification.service;

import com.yonghui.common.util.DateUtil;
import com.yonghui.internal.notification.dto.MessageInfo;
import com.yonghui.internal.notification.dto.MessageProperty;
import com.yonghui.internal.notification.dto.MessageType;
import com.yonghui.internal.notification.dto.ResultSet;
import com.yonghui.internal.notification.mapper.NotificationSendMapper;
import com.yonghui.internal.notification.model.NotificationSend;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:邮件操作类
 *
 * @Author: chenjie
 * @Date: 2017-07-24 13:49
 */
public class EmailMessageHandler implements MessageOperation{

    private List<ResultSet> resultSets;

    private JavaMailSender javaMailSender;

    private NotificationSendMapper notificationSendMapper;

    //@Value("${spring.mail.username}")
    private String userName;

    private List<NotificationSend> retryList = new ArrayList<>();

    private int retryNum;

    public EmailMessageHandler(List<ResultSet> resultSets, JavaMailSender javaMailSender,
            NotificationSendMapper notificationSendMapper,String userName){
        this.resultSets = resultSets;
        this.javaMailSender = javaMailSender;
        this.notificationSendMapper = notificationSendMapper;
        this.userName = userName;
    }

    @Override
    public void sendMessage(MessageInfo messageInfo, MessageProperty messageProperty, Long messageId) {

        boolean privateMail = false;
        ResultSet resultSet = new ResultSet();
        //是否自定义发件箱
        if (messageInfo.getMessageFrom() == null){
            messageInfo.setMessageFrom(new MessageInfo.privateMail());
        }
        if (!StringUtils.isEmpty(messageInfo.getMessageFrom().getMailAccount()) && !StringUtils.isEmpty(messageInfo.getMessageFrom().getMailPassword()) &&
            !StringUtils.isEmpty(messageInfo.getMessageFrom().getMailHost()) && messageInfo.getMessageFrom().getMailport() != null){
            JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
            javaMail.setHost(messageInfo.getMessageFrom().getMailHost());
            javaMail.setPort(messageInfo.getMessageFrom().getMailport());
            javaMail.setUsername(messageInfo.getMessageFrom().getMailAccount());
            javaMail.setPassword(messageInfo.getMessageFrom().getMailPassword());
            javaMailSender = javaMail;
            privateMail = true;
        }else{
            //todo 通知信息不全已按照默认邮箱发送
        }
        //分析收件人
        String[] toUser = messageInfo.getMessageTo().split(",");

        String subject = messageInfo.getMessageTitle();
        MimeMessage msg = javaMailSender.createMimeMessage();
        //入库
        for (String user:toUser) {
            NotificationSend notificationSend = new NotificationSend();
            notificationSend.setChannelId(2L).setMessageId(messageId)
                    .setSendState("unsend").setSendReceiverAddress(user)
                    .setSendAddress(privateMail ? messageInfo.getMessageFrom()
                            .getMailAccount() : userName).setSendRetryNum(retryNum)
                    .setSendTime(DateUtil.getCurrentTime()).setSendPrepareTime(messageProperty.getSendDate())
                    .setSendExtraMessage(messageInfo.getMessageFrom().getMailCCList())
                    .setCreateUser(0).setCreateTime(DateUtil.getCurrentTime()).setSendMessageState("process");
            if (messageProperty.isReadReport()){
                notificationSend.setSendReadReport("unread");
            }
            try {
                notificationSendMapper.insert(notificationSend);

                MimeMessageHelper helper = new MimeMessageHelper(msg, true);
                helper.setTo(user);
                helper.setSubject(subject);
                if (privateMail) {
                    helper.setFrom(messageInfo.getMessageFrom().getMailAccount());
                } else {
                    helper.setFrom(userName);
                }
                //判断文本类型
                if (messageProperty.getTextType() == 1) {
                    helper.setText(messageInfo.getMessageText());
                } else if (messageProperty.getTextType() == 2) {
                    helper.setText(messageInfo.getMessageText(), true);
                }
                //判断是否有抄送人
                if (!StringUtils.isEmpty(messageInfo.getMessageFrom().getMailCCList())) {
                    String[] CC = messageInfo.getMessageFrom().getMailCCList().split(",");
                    helper.setCc(CC);
                }
                //todo 上传文件流
                //helper.addAttachment("ehcache.xsd", file);
                javaMailSender.send(msg);
                resultSet.setSendResult(true);
                //入库成功状态
                NotificationSend notificationSendUpdate = new NotificationSend();
                notificationSendUpdate.setSendId(notificationSend.getSendId());
                notificationSendUpdate.setSendState("success");
                notificationSendUpdate.setUpdateUser(0);
                notificationSendUpdate.setUpdateTime(DateUtil.getCurrentTime());
                notificationSendMapper.updateByPrimaryKeySelective(notificationSendUpdate);
            } catch (Exception e) {
                e.printStackTrace();
                retryList.add(notificationSend);
            }
        }
        if (messageProperty.getRetryNum() > 0 && retryList.size() > 0){
            //重试
            while (messageProperty.getRetryNum() > retryNum){
                retryNum++;
                retrySendEmail(messageInfo, messageProperty, privateMail, resultSet);
            }
        }
        //输入最后失败的状态
        if (retryList.size() > 0){
            for (NotificationSend faildNotificationSend:retryList) {
                NotificationSend notificationSendUpdate = new NotificationSend();
                notificationSendUpdate.setSendId(faildNotificationSend.getSendId());
                notificationSendUpdate.setSendState("failure");
                notificationSendUpdate.setUpdateUser(0);
                notificationSendUpdate.setUpdateTime(DateUtil.getCurrentTime());
                notificationSendUpdate.setSendRetryNum(retryNum);
                notificationSendMapper.updateByPrimaryKeySelective(notificationSendUpdate);
            }
        }
        resultSet.setSendName(MessageType.EMAILMESSAGE.getKey());
        resultSet.setSendResult(!(retryList.size() > 0));
        resultSets.add(resultSet);
    }


    private void retrySendEmail(MessageInfo messageInfo, MessageProperty messageProperty, boolean privateMail, ResultSet resultSet){

        for (NotificationSend notificationSend : retryList) {
            try {
                //判断是否入库
                if (notificationSend.getSendId() == null){
                    notificationSendMapper.insert(notificationSend);
                }

                MimeMessage msg = javaMailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(msg, true);
                helper.setTo(notificationSend.getSendReceiverAddress());
                helper.setSubject(messageInfo.getMessageTitle());
                if (privateMail) {
                    helper.setFrom(messageInfo.getMessageFrom().getMailAccount());
                } else {
                    helper.setFrom(userName);
                }
                //判断文本类型
                if (messageProperty.getTextType() == 1) {
                    helper.setText(messageInfo.getMessageText());
                } else if (messageProperty.getTextType() == 2) {
                    helper.setText(messageInfo.getMessageText(), true);
                }
                //判断是否有抄送人
                if (!StringUtils.isEmpty(messageInfo.getMessageFrom().getMailCCList())) {
                    String[] CC = messageInfo.getMessageFrom().getMailCCList().split(",");
                    helper.setCc(CC);
                }
                javaMailSender.send(msg);
                resultSet.setSendResult(true);
                //入库成功状态
                NotificationSend notificationSendUpdate = new NotificationSend();
                notificationSendUpdate.setSendId(notificationSend.getSendId());
                notificationSendUpdate.setSendState("success");
                notificationSendUpdate.setUpdateUser(0);
                notificationSendUpdate.setSendRetryNum(retryNum);
                notificationSendUpdate.setUpdateTime(DateUtil.getCurrentTime());
                notificationSendMapper.updateByPrimaryKeySelective(notificationSendUpdate);
                retryList.remove(notificationSend);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }

}
