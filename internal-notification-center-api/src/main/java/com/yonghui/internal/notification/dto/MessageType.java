package com.yonghui.internal.notification.dto;

/**
 * Description:消息渠道枚举类
 *
 * @Author: chenjie
 * @Date: 2017-07-24 10:12
 */

public enum MessageType {
    /**
     * 网页信息
     */
    WEBMESSAGE(1,"webMessage"),
    /**
     * 邮件
     */
    EMAILMESSAGE(2,"emailMessage"),
    /**
     * 微信
     */
    WECHATMESSAGE(3,"wechatMessage"),
    /**
     * 短信
     */
    NOTEMESSAGE(4,"noteMessage"),
    /**
     * 电话
     */
    PHONEMESSAGE(5,"phoneMessage");


    private int value;

    private String key;

    MessageType(){
    }

    MessageType(int value, String key){
        this.value = value;
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
