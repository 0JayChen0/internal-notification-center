package com.yonghui.internal.notification.service;

import com.yonghui.internal.notification.dto.MessageInfo;
import com.yonghui.internal.notification.dto.MessageProperty;

/**
 * Description:订阅与发布接口
 *
 * @Author: chenjie
 * @Date: 2017-07-24 16:28
 */
public interface MessageSubject {

    /**
     * 增加订阅者
     * @param observer
     */
    void attach(MessageOperation observer);
    /**
     * 删除订阅者
     * @param observer
     */
    void detach(MessageOperation observer);

    /**
     * 清空订阅者
     */
    void cleanObserver();
    /**
     * 通知订阅者发送消息
     */
    void notify(MessageInfo messageInfo, MessageProperty messageProperty, Long messageId);

}
