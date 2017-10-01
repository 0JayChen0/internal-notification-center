package com.yonghui.internal.notification.service;

import com.yonghui.internal.notification.dto.MessageInfo;
import com.yonghui.internal.notification.dto.MessageProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:被观察者实现
 *
 * @Author: chenjie
 * @Date: 2017-07-24 16:32
 */
public class MessageSubjectImpl implements MessageSubject{


    private List<MessageOperation> messageOperationList = new ArrayList<>();

    /**
     * 增加订阅者
     *
     * @param observer
     */
    @Override
    public void attach(MessageOperation observer) {
        this.messageOperationList.add(observer);
    }

    /**
     * 删除订阅者
     *
     * @param observer
     */
    @Override
    public void detach(MessageOperation observer) {
        this.messageOperationList.remove(observer);
    }

    /**
     * 清空订阅者
     *
     */
    @Override
    public void cleanObserver() {
        this.messageOperationList.clear();
    }

    /**
     * 通知订阅者发布消息
     *
     * @param messageInfo
     * @param messageProperty
     */
    @Override
    public void notify(MessageInfo messageInfo, MessageProperty messageProperty, Long messageId) {
        for(MessageOperation messageOperation:messageOperationList){
            try {
                messageOperation.sendMessage(messageInfo, messageProperty, messageId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
