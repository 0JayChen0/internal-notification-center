package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * Description:查询历史消息参数类
 *
 * @Author: chenjie
 * @Date: 2017-07-28 10:20
 */
@Data
@NoArgsConstructor
public class SelectHistory implements Serializable {
    /**
     * 消息接收人
     */
    String toUser;
    /**
     * 消息发送人
     */
    String sendUser;
    /**
     * 消息类型
     */
    MessageType messageType;
    /**
     * 消息开始时间
     */
    @NonNull
    String messageStartDate;
    /**
     * 消息结束时间
     */
    @NonNull
    String messageEndDate;
}
