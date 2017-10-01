package com.yonghui.internal.notification.service;

import com.yonghui.internal.notification.dto.MessageInfo;
import com.yonghui.internal.notification.dto.MessageProperty;
import com.yonghui.internal.notification.dto.MessageType;
import com.yonghui.internal.notification.dto.ResultSet;

import java.util.List;

/**
 * Description:电话消息操作类
 *
 * @Author: chenjie
 * @Date: 2017-07-24 18:19
 */
public class PhoneMessageHandler implements MessageOperation{

    private List<ResultSet> resultSets;

    public PhoneMessageHandler(List<ResultSet> resultSets){
        this.resultSets = resultSets;
    }

    @Override
    public void sendMessage(MessageInfo messageInfo, MessageProperty messageProperty, Long messageId) {
        //todo 具体发送及数据入库步骤


        ResultSet resultSet = new ResultSet();
        resultSet.setSendName(MessageType.PHONEMESSAGE.getKey());
        resultSet.setSendResult(false);
        resultSets.add(resultSet);
    }
}
