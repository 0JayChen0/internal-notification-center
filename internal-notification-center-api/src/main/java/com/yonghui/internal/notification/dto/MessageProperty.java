package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.util.List;

/**
 * Description:消息属性
 *
 * @Author: chenjie
 * @Date: 2017-07-24 11:12
 */
@Data
@NoArgsConstructor
public class MessageProperty implements Serializable {

    /**
     * 升级执行消息队列(如果队列为空则按照默认顺序和类别执行)
     */
    protected List<MessageRank> messageRank;
    /**
     * 是否失败后升级级别发送
     */
    private boolean upgrade;
    /**
     * 文本类型（1--普通文本，2--html文本）
     */
    @NonNull
    private int textType;
    /**
     * 定时发送时间（传null则不定时）
     */
    private String sendDate;
    /**
     * 是否发送已读回执（true--发送，false--不发送）
     */
    private boolean readReport;
    /**
     * 重试次数（0--不重试）
     */
    private int retryNum;
}
