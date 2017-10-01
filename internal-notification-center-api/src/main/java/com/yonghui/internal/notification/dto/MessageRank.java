package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:渠道对象
 *
 * @Author: chenjie
 * @Date: 2017-07-31 18:30
 */
@Data
@NoArgsConstructor
public class MessageRank implements Serializable {
    /**
     * 消息类型(使用{@link MessageType })
     */
    private MessageType messageType;
    /**
     * 消息级别（-1为按默认分级，0--不分级，1最低，级别按数字依次上涨）
     */
    private int rank;
}
