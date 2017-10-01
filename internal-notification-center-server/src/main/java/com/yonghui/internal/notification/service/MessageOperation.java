package com.yonghui.internal.notification.service;

import com.yonghui.internal.notification.dto.MessageInfo;
import com.yonghui.internal.notification.dto.MessageProperty;

/**
 * Description:消息操作接口
 *
 * @Author: chenjie
 * @Date: 2017-07-24 13:47
 */
public interface MessageOperation {


    void sendMessage(MessageInfo messageInfo, MessageProperty messageProperty, Long messageId);

}
