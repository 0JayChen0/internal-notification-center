package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:消息返回实体类
 *
 * @Author: chenjie
 * @Date: 2017-07-25 16:40
 */
@Data
@NoArgsConstructor
public class MessageReturn implements Serializable {

    /**
     * 消息ID
     */
    Long sendId;
    /**
     * 消息标题
     */
    String messageTitle;
    /**
     * 消息内容
     */
    String messageText;
    /**
     * 消息接收人
     */
    String toUser;
    /**
     * 消息发送人
     */
    String fromUser;
    /**
     * 消息发送时间
     */
    String sendTime;
    /**
     * 消息发送渠道
     */
    MessageType messageType;
}
