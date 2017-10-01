package com.yonghui.internal.notification.service;

import com.yonghui.common.util.DateUtil;
import com.yonghui.internal.notification.dto.MessageInfo;
import com.yonghui.internal.notification.dto.MessageProperty;
import com.yonghui.internal.notification.dto.MessageType;
import com.yonghui.internal.notification.dto.ResultSet;
import com.yonghui.internal.notification.mapper.NotificationSendMapper;
import com.yonghui.internal.notification.model.NotificationSend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:网页消息操作类
 *
 * @Author: chenjie
 * @Date: 2017-07-24 18:13
 */
public class WebMessageHandler implements MessageOperation{

    private List<ResultSet> resultSets;

    private int retryNum;

    private List<String> toUserList;

    private NotificationSendMapper notificationSendMapper;

    public WebMessageHandler(List<ResultSet> resultSets, NotificationSendMapper notificationSendMapper){
        this.resultSets = resultSets;
        this.notificationSendMapper = notificationSendMapper;
    }

    @Override
    public void sendMessage(MessageInfo messageInfo, MessageProperty messageProperty, Long messageId) {
        //分析收件人
        String[] toUser = messageInfo.getMessageTo().split(",");
        if (toUserList != null && toUserList.size() > 0){
            toUser = toUserList.toArray(toUser);
        }else{
            toUserList = new ArrayList<>();
            Collections.addAll(toUserList, toUser);
        }

        //依次插入数据
        for (String user:toUser) {
            try {
                NotificationSend notificationSend = new NotificationSend();
                notificationSend.setChannelId(1L).setMessageId(messageId)
                        .setSendState("success")
                        .setSendReceiverAddress(user).setSendAddress(messageInfo.getMessageSendName())
                        .setSendRetryNum(retryNum).setSendTime(DateUtil.getCurrentTime())
                        .setSendPrepareTime(messageProperty.getSendDate())
                        .setSendReadReport(messageProperty.isReadReport() ? "unread" : "")
                        .setCreateUser(0).setCreateTime(DateUtil.getCurrentTime()).setSendMessageState("process");
                if (messageInfo.getMessageFrom() != null){
                    notificationSend.setSendExtraMessage(messageInfo.getMessageFrom().getMailCCList());
                }
                notificationSendMapper.insert(notificationSend);
                toUserList.remove(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //插入失败的重试
        if (messageProperty.getRetryNum() > retryNum && toUserList.size() > 0){
            retryNum++;
            this.sendMessage(messageInfo, messageProperty, messageId);
        }
        ResultSet resultSet = new ResultSet();
        resultSet.setSendName(MessageType.WEBMESSAGE.getKey());
        resultSet.setSendResult(!(toUserList.size() > 0));
        resultSets.add(resultSet);
    }

}
