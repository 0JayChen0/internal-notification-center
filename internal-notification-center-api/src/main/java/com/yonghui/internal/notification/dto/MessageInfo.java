package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;

/**
 * Description:消息传入类
 *
 * @Author: chenjie
 * @Date: 2017-07-24 09:32
 */
@Data
@NoArgsConstructor
public class MessageInfo implements Serializable{

    /**
     * 消息内容
     */
    @NonNull
    private String messageText;
    /**
     * 消息发给人
     */
    @NonNull
    private String messageTo;
    /**
     * 消息来源(邮箱发送可选)
     */
    protected privateMail messageFrom;
    /**
     * 消息标题
     */
    private String messageTitle = "";
    /**
     * 消息署名
     */
    private String messageSendName = "";
    /**
     * 消息类型
     */
    private MessageType messageType;
    @Data
    @NoArgsConstructor
    public static class privateMail implements Serializable{
        /**
         * 邮箱账号
         */
        private String mailAccount;
        /**
         * 邮箱密码
         */
        private String mailPassword;
        /**
         * 邮箱smtp地址
         */
        private String mailHost;
        /**
         * 邮箱端口
         */
        private Integer mailport;
        /**
         * 抄送人（多个账号用逗号隔开）
         */
        private String mailCCList;
    }
}
