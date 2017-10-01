package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description:邮件发送参数类
 *
 * @Author: chenjie
 * @Date: 2017-07-31 19:11
 */
@Data
@NoArgsConstructor
public class SendEmailInfo {

    private MessageInfo messageInfo;

    private List<MessageRank> messageRankList;
}
