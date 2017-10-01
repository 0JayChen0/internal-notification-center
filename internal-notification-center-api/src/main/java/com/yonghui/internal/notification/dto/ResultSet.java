package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:返回的结果集
 *
 * @Author: chenjie
 * @Date: 2017-07-24 15:39
 */
@Data
@NoArgsConstructor
public class ResultSet implements Serializable {

    /**
     * 发送渠道名称
     */
    String sendName;
    /**
     * 发送结果
     */
    boolean sendResult;

}
