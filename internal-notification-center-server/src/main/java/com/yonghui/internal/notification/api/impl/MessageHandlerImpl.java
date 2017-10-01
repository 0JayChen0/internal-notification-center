package com.yonghui.internal.notification.api.impl;

import com.yonghui.common.util.DateUtil;
import com.yonghui.internal.notification.api.MessageHandler;
import com.yonghui.internal.notification.dto.AllMessageInfo;
import com.yonghui.internal.notification.dto.MessageInfo;
import com.yonghui.internal.notification.dto.MessageProperty;
import com.yonghui.internal.notification.dto.MessageRank;
import com.yonghui.internal.notification.dto.MessageRankList;
import com.yonghui.internal.notification.dto.MessageReturn;
import com.yonghui.internal.notification.dto.MessageType;
import com.yonghui.internal.notification.dto.ResultSet;
import com.yonghui.internal.notification.dto.SelectHistory;
import com.yonghui.internal.notification.dto.SendEmailInfo;
import com.yonghui.internal.notification.mapper.NotificationMessageMapper;
import com.yonghui.internal.notification.mapper.NotificationSendMapper;
import com.yonghui.internal.notification.model.NotificationMessage;
import com.yonghui.internal.notification.model.NotificationSend;
import com.yonghui.internal.notification.model.NotificationSendExample;
import com.yonghui.internal.notification.service.EmailMessageHandler;
import com.yonghui.internal.notification.service.MessageSubject;
import com.yonghui.internal.notification.service.MessageSubjectImpl;
import com.yonghui.internal.notification.service.NoteMessageHandler;
import com.yonghui.internal.notification.service.PhoneMessageHandler;
import com.yonghui.internal.notification.service.WebMessageHandler;
import com.yonghui.internal.notification.service.WechatMessageHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:消息流程处理类
 *
 * @Author: chenjie
 * @Date: 2017-07-24 13:38
 */
@RestController
public class MessageHandlerImpl implements MessageHandler{

    private MessageSubject messageSubject = new MessageSubjectImpl();
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private NotificationMessageMapper notificationMessageMapper;
    @Autowired
    private NotificationSendMapper notificationSendMapper;

    @Value("${spring.mail.username}")
    private String userName;


    /**
     * 简单网页消息发送(失败重试3次，再失败不换渠道发送，普通文本，不发送已读回执)
     *
     * @param messageText 消息内容
     * @param messageTo   消息接收人(多个用逗号隔开)
     * @return
     */
    @Override
    public boolean sendSimpleWebMessage(@RequestParam("messageText") String messageText,@RequestParam("messageTo") String messageTo) {
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageText(messageText);
        messageInfo.setMessageTo(messageTo);
        messageInfo.setMessageType(MessageType.WEBMESSAGE);
        messageInfo.setMessageSendName("system");
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(false);
        messageProperty.setTextType(1);
        List<ResultSet> resultSets = this.sendMessageInvoice(messageInfo, messageProperty);
        return resultSets.get(0).isSendResult();
    }

    /**
     * 网页消息发送(失败重试3次，普通文本，需发送已读回执)
     *
     * @param messageText     消息内容
     * @param messageTo       消息接收人(多个用逗号隔开)
     * @param messageTitle    消息标题
     * @param messageSendName 消息署名
     * @param messageRankList     消息发送渠道列表(填null代表失败不换渠道发送)
     * @return
     */
    @Override
    public List<ResultSet> sendWebMessageWithRead(
            @RequestParam("messageText") String messageText,
            @RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,
            @RequestParam("messageSendName") String messageSendName,
            @RequestBody MessageRankList messageRankList) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageText(messageText);
        messageInfo.setMessageTo(messageTo);
        messageInfo.setMessageTitle(messageTitle);
        messageInfo.setMessageSendName(messageSendName);
        messageInfo.setMessageType(MessageType.WEBMESSAGE);
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(true);
        messageProperty.setTextType(1);
        if (messageRankList != null){
            messageProperty.setUpgrade(true);
        }
        messageProperty.setMessageRank(messageRankList.getMessageRankList());
        return this.sendMessageInvoice(messageInfo, messageProperty);
    }

    /**
     * 网页消息发送(失败重试3次，普通文本，不需发送已读回执)
     *
     * @param messageText     消息内容
     * @param messageTo       消息接收人(多个用逗号隔开)
     * @param messageTitle    消息标题
     * @param messageSendName 消息署名
     * @param messageRankList     消息发送渠道列表(填null代表失败不换渠道发送)
     * @return
     */
    @Override
    public List<ResultSet> sendWebMessageWithoutRead(
            @RequestParam("messageText") String messageText,
            @RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,
            @RequestParam("messageSendName") String messageSendName,
            @RequestBody MessageRankList messageRankList) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageText(messageText);
        messageInfo.setMessageTo(messageTo);
        messageInfo.setMessageTitle(messageTitle);
        messageInfo.setMessageSendName(messageSendName);
        messageInfo.setMessageType(MessageType.WEBMESSAGE);
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(false);
        messageProperty.setTextType(1);
        if (messageRankList != null){
            messageProperty.setUpgrade(true);
        }
        messageProperty.setMessageRank(messageRankList.getMessageRankList());
        return this.sendMessageInvoice(messageInfo, messageProperty);
    }

    /**
     * 简单的邮件发送(失败重试3次，再失败不换渠道发送，普通文本，不发送已读回执，无抄送，使用默认邮箱)
     *
     * @param messageText 消息内容
     * @param messageTo   消息接收人(多个用逗号隔开)
     * @return
     */
    @Override
    public boolean sendSimpleEmail(@RequestParam("messageText") String messageText, @RequestParam("messageTo") String messageTo) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageText(messageText);
        messageInfo.setMessageTo(messageTo);
        messageInfo.setMessageType(MessageType.EMAILMESSAGE);
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(false);
        messageProperty.setTextType(1);
        List<ResultSet> resultSets = this.sendMessageInvoice(messageInfo, messageProperty);
        return resultSets.get(0).isSendResult();

    }

    /**
     * 邮件发送(失败重试3次，普通文本，不需发送已读回执，使用默认邮箱)
     *
     * @param messageText     消息内容
     * @param messageTo       消息接收人(多个用逗号隔开)
     * @param messageTitle    消息标题
     * @param messageSendName 消息署名
     * @param messageCC       抄送人(多个用逗号隔开)
     * @param messageRankList     消息发送渠道列表(填null代表失败不换渠道发送)
     * @return
     */
    @Override
    public List<ResultSet> sendEmailWithoutRead(
            @RequestParam("messageText")String messageText,
            @RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,
            @RequestParam("messageSendName") String messageSendName,
            @RequestParam("messageCC") String messageCC,
            @RequestBody MessageRankList messageRankList) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageText(messageText);
        messageInfo.setMessageTo(messageTo);
        messageInfo.setMessageTitle(messageTitle);
        messageInfo.setMessageSendName(messageSendName);
        MessageInfo.privateMail privateMail = new MessageInfo.privateMail();
        messageInfo.setMessageType(MessageType.EMAILMESSAGE);
        privateMail.setMailCCList(messageCC);
        messageInfo.setMessageFrom(privateMail);
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(false);
        messageProperty.setTextType(1);
        if (messageRankList != null){
            messageProperty.setUpgrade(true);
        }
        messageProperty.setMessageRank(messageRankList.getMessageRankList());
        return this.sendMessageInvoice(messageInfo, messageProperty);

    }

    /**
     * 邮件发送(失败重试3次，普通文本，需发送已读回执，使用默认邮箱)
     *
     * @param messageText     消息内容
     * @param messageTo       消息接收人(多个用逗号隔开)
     * @param messageTitle    消息标题
     * @param messageSendName 消息署名
     * @param messageCC       抄送人(多个用逗号隔开)
     * @param messageRankList     消息发送渠道列表(填null代表失败不换渠道发送)
     * @return
     */
    @Override
    public List<ResultSet> sendEmailWithRead(
            @RequestParam("messageText") String messageText,
            @RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,
            @RequestParam("messageSendName") String messageSendName,
            @RequestParam("messageCC") String messageCC,
            @RequestBody MessageRankList messageRankList) {

        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setMessageText(messageText);
        messageInfo.setMessageTo(messageTo);
        messageInfo.setMessageTitle(messageTitle);
        messageInfo.setMessageSendName(messageSendName);
        messageInfo.setMessageType(MessageType.EMAILMESSAGE);
        MessageInfo.privateMail privateMail = new MessageInfo.privateMail();
        privateMail.setMailCCList(messageCC);
        messageInfo.setMessageFrom(privateMail);
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(true);
        messageProperty.setTextType(1);
        if (messageRankList != null){
            messageProperty.setUpgrade(true);
        }
        messageProperty.setMessageRank(messageRankList.getMessageRankList());
        return this.sendMessageInvoice(messageInfo, messageProperty);
    }

    /**
     * 邮件发送(失败重试3次，普通文本，需发送已读回执，使用自定义邮箱)
     *
     * @param sendEmailInfo 消息对象
     * @return
     */
    @Override
    public List<ResultSet> sendEmailWithReadForMailBox(@RequestBody SendEmailInfo sendEmailInfo) {
        sendEmailInfo.getMessageInfo().setMessageType(MessageType.EMAILMESSAGE);
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(true);
        messageProperty.setTextType(1);
        if (sendEmailInfo.getMessageRankList() != null){
            messageProperty.setUpgrade(true);
        }
        messageProperty.setMessageRank(sendEmailInfo.getMessageRankList());
        return this.sendMessageInvoice(sendEmailInfo.getMessageInfo(), messageProperty);
    }

    /**
     * 邮件发送(失败重试3次，普通文本，不需发送已读回执，使用自定义邮箱)
     *
     * @param sendEmailInfo 消息对象
     * @return
     */
    @Override
    public List<ResultSet> sendEmailWithoutReadForMailBox(@RequestBody SendEmailInfo sendEmailInfo) {
        sendEmailInfo.getMessageInfo().setMessageType(MessageType.EMAILMESSAGE);
        MessageProperty messageProperty = new MessageProperty();
        messageProperty.setRetryNum(3);
        messageProperty.setReadReport(false);
        messageProperty.setTextType(1);
        if (sendEmailInfo.getMessageRankList() != null){
            messageProperty.setUpgrade(true);
        }
        messageProperty.setMessageRank(sendEmailInfo.getMessageRankList());
        return this.sendMessageInvoice(sendEmailInfo.getMessageInfo(), messageProperty);
    }

    /**
     * 发送消息
     *
     * @param allMessageInfo 消息完整信息
     * @return 返回消息各渠道发送状态列表
     */
    @Override
    public List<ResultSet> sendMessage(@RequestBody AllMessageInfo allMessageInfo){
        MessageInfo messageInfo = allMessageInfo.getMessageInfo();
        MessageProperty messageProperty = allMessageInfo.getMessageProperty();
        return sendMessageInvoice(messageInfo, messageProperty);
    }




    private List<ResultSet> sendMessageInvoice(MessageInfo messageInfo, MessageProperty messageProperty) {

        List<ResultSet> resultSetList = new ArrayList<>();
        List<Integer> unexecuted = new ArrayList<>();
        List<MessageRank> messageRankList = messageProperty.getMessageRank();

        //请求数据整理
        if ((StringUtils.isEmpty(messageInfo.getMessageTitle()) && messageInfo.getMessageType().equals(MessageType.EMAILMESSAGE)) ||
                (messageProperty.isUpgrade() && StringUtils.isEmpty(messageInfo.getMessageTitle()))){
            if (messageInfo.getMessageText().length() > 10){
                messageInfo.setMessageTitle(messageInfo.getMessageText().substring(0,10));
            }else{
                messageInfo.setMessageTitle(messageInfo.getMessageText());
            }
        }

        // 消息入库
        NotificationMessage notificationMessage = new NotificationMessage();
        notificationMessage.setMessageText(messageInfo.getMessageText()).setMessageSendName(messageInfo.getMessageSendName())
                           .setMessageTitle(messageInfo.getMessageTitle()).setCreateTime(DateUtil.getCurrentTime()).setCreateUser(0);
        notificationMessageMapper.insert(notificationMessage);

        //判断是否为失败后升级发送
        if (!messageProperty.isUpgrade()) {
            switchObverse(messageInfo.getMessageType().getValue(), resultSetList);
            if (messageRankList != null && !messageRankList.isEmpty()) {
                for (MessageRank messageRank : messageRankList) {
                    switchObverse(messageRank.getMessageType().getValue(), resultSetList);
                }
            }
            messageSubject.notify(messageInfo, messageProperty, notificationMessage.getMessageId());
        }else{
            switchObverse(messageInfo.getMessageType().getValue(), resultSetList);
            messageSubject.notify(messageInfo, messageProperty, notificationMessage.getMessageId());
            // 判断发送结果集中是否有一种渠道执行成功
            boolean isOneSuccess = false;
            for (ResultSet resultSet:resultSetList){
                if (resultSet.isSendResult()){
                    isOneSuccess = true;
                }
            }
            // 如果没有成功的，则获取未执行的所有渠道
            if(!isOneSuccess) {
                if (messageRankList == null || messageRankList.isEmpty()) {
                    for (int i = 0; i < MessageType.class.getEnumConstants().length; i++) {
                        boolean isbreak = false;
                        for (int j = 0; j < resultSetList.size(); j++) {
                            if (MessageType.class.getEnumConstants()[i].getKey().equals(resultSetList.get(j).getSendName())) {
                                isbreak = true;
                                break;
                            }
                        }
                        if (isbreak) {
                            continue;
                        } else {
                            unexecuted.add(MessageType.class.getEnumConstants()[i].getValue());
                        }
                    }
                }else {
                    for (MessageRank messageRank : messageRankList) {
                        unexecuted.add(messageRank.getMessageType().getValue());
                    }
                }
                // 依次执行未执行方法直到成功
                for(Integer num:unexecuted) {
                    messageSubject.cleanObserver();
                    switchObverse(num, resultSetList);
                    messageSubject.notify(messageInfo, messageProperty, notificationMessage.getMessageId());
                    if (resultSetList.get(resultSetList.size() - 1).isSendResult()) {
                        break;
                    }
                }
            }
        }
        return resultSetList;
    }

    /**
     * 接收消息
     *
     * @param toUser      消息接收人
     * @param messageType 消息类型
     * @param messageDate 查询开始时间
     * @return
     */
    @Override
    public List<MessageReturn> getMessage(
            @RequestParam("toUser") String toUser,
            @RequestParam("messageType") MessageType messageType,
            @RequestParam("messageDate") String messageDate) {

        List<MessageReturn> messageReturnList = new ArrayList<>();

        //查询出发送列表
        NotificationSendExample notificationSendExample = new NotificationSendExample();
        notificationSendExample.createCriteria().andSendReceiverAddressEqualTo(toUser)
                .andChannelIdEqualTo(Long.parseLong(messageType.getValue() + "")).andCreateTimeGreaterThan(messageDate)
                .andSendStateEqualTo("success").andSendReadReportNotEqualTo("read").andSendMessageStateEqualTo("process");
        List<NotificationSend> notificationSendList = notificationSendMapper.selectByExample(notificationSendExample);
        //按照发送列表查询出对应的消息内容
        for (NotificationSend notificationSend:notificationSendList){
            MessageReturn messageReturn = new MessageReturn();
            NotificationMessage notificationMessage = notificationMessageMapper.selectByPrimaryKey(notificationSend.getMessageId());
            messageReturn.setFromUser(notificationMessage.getMessageSendName());
            messageReturn.setMessageText(notificationMessage.getMessageText());
            messageReturn.setMessageTitle(notificationMessage.getMessageTitle());
            messageReturn.setMessageType(messageType);
            messageReturn.setSendTime(notificationMessage.getCreateTime());
            messageReturn.setToUser(notificationSend.getSendAddress());
            messageReturn.setSendId(notificationSend.getSendId());
            //组装返回消息
            messageReturnList.add(messageReturn);
        }
        return messageReturnList;
    }

    /**
     * 通知消息已读
     *
     * @param sendid 发送ID
     * @return
     */
    @RequestMapping(value = "/messageIsRead")
    @Override
    public void messageIsRead(@RequestParam("sendid") String sendid) {
        for(String id:sendid.split(",")){
            NotificationSend notificationSend = notificationSendMapper.selectByPrimaryKey(Long.parseLong(id));
            if (notificationSend.getSendReadReport().equals("")){
                return ;
            }
            NotificationSend record = new NotificationSend();
            record.setSendId(Long.parseLong(id));
            record.setUpdateTime(DateUtil.getCurrentTime());
            record.setUpdateUser(0);
            record.setSendReadReport("read");
            notificationSendMapper.updateByPrimaryKeySelective(record);
        }
    }

    /**
     * 查询历史消息
     *
     * @param selectHistory 查询参数类
     * @return
     */
    @Override
    public List<MessageReturn> selectHistoryMessage(@RequestBody SelectHistory selectHistory) {
        ArrayList<MessageReturn> messageReturnList = new ArrayList<>();

        //查询出发送列表
        NotificationSendExample notificationSendExample = new NotificationSendExample();
        NotificationSendExample.Criteria criteria = notificationSendExample.createCriteria()
                .andCreateTimeGreaterThan(selectHistory.getMessageStartDate()).andCreateTimeLessThan(selectHistory.getMessageEndDate())
                .andSendReadReportNotEqualTo("unread");
        if (StringUtils.isEmpty(selectHistory.getToUser())){
            criteria.andSendAddressEqualTo(selectHistory.getToUser());
        }
        if (selectHistory.getMessageType() != null) {
            criteria.andChannelIdEqualTo(Long.parseLong(selectHistory.getMessageType().getValue() + ""));
        }
        if (!StringUtils.isEmpty(selectHistory.getToUser())){
            criteria.andSendReceiverAddressEqualTo(selectHistory.getToUser());
        }
        if (!StringUtils.isEmpty(selectHistory.getSendUser())){
            criteria.andSendAddressEqualTo(selectHistory.getSendUser());
        }

        List<NotificationSend> notificationSendList = notificationSendMapper.selectByExample(notificationSendExample);
        //按照发送列表查询出对应的消息内容
        for (NotificationSend notificationSend:notificationSendList){
            MessageReturn messageReturn = new MessageReturn();
            NotificationMessage notificationMessage = notificationMessageMapper.selectByPrimaryKey(notificationSend.getMessageId());
            messageReturn.setFromUser(notificationMessage.getMessageSendName());
            messageReturn.setMessageText(notificationMessage.getMessageText());
            messageReturn.setMessageTitle(notificationMessage.getMessageTitle());
            messageReturn.setMessageType(selectHistory.getMessageType());
            messageReturn.setSendTime(notificationMessage.getCreateTime());
            messageReturn.setToUser(notificationSend.getSendReceiverAddress());
            messageReturn.setSendId(notificationSend.getSendId());
            //组装返回消息
            messageReturnList.add(messageReturn);
        }

        return messageReturnList;
    }

    private void switchObverse(int num, List<ResultSet> resultSets){
        switch (num){
            case 1:{
                // 加入网页观察者
                messageSubject.attach(new WebMessageHandler(resultSets, notificationSendMapper));
            }break;
            case 2:{
                //加入邮件观察者
                messageSubject.attach(new EmailMessageHandler(resultSets, javaMailSender, notificationSendMapper, userName));
            }break;
            case 3:{
                // 加入微信观察者
                messageSubject.attach(new WechatMessageHandler(resultSets));
            }break;
            case 4:{
                // 加入短信观察者
                messageSubject.attach(new NoteMessageHandler(resultSets));
            }break;
            case 5:{
                // 加入电话观察者
                messageSubject.attach(new PhoneMessageHandler(resultSets));
            }break;
        }
    }
}
