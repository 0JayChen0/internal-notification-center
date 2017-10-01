package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:完整消息请求对象
 *
 * @Author: chenjie
 * @Date: 2017-07-31 19:13
 */
@Data
@NoArgsConstructor
public class AllMessageInfo {

    private MessageInfo messageInfo;

    private MessageProperty messageProperty;
}
