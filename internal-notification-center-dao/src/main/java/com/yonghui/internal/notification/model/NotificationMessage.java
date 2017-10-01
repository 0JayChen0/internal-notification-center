package com.yonghui.internal.notification.model;

public class NotificationMessage {
    private Long messageId;

    private String messageText;

    private String messageTitle;

    private String messageFile;

    private String messageSendName;

    private Integer createUser;

    private String createTime;

    private Integer updateUser;

    private String updateTime;

    private String lastUpdateTime;

    public Long getMessageId() {
        return messageId;
    }

    public NotificationMessage setMessageId(Long messageId) {
        this.messageId = messageId;
        return this;
    }

    public String getMessageText() {
        return messageText;
    }

    public NotificationMessage setMessageText(String messageText) {
        this.messageText = messageText;
        return this;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public NotificationMessage setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
        return this;
    }

    public String getMessageFile() {
        return messageFile;
    }

    public NotificationMessage setMessageFile(String messageFile) {
        this.messageFile = messageFile;
        return this;
    }

    public String getMessageSendName() {
        return messageSendName;
    }

    public NotificationMessage setMessageSendName(String messageSendName) {
        this.messageSendName = messageSendName;
        return this;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public NotificationMessage setCreateUser(Integer createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public NotificationMessage setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public NotificationMessage setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public NotificationMessage setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public NotificationMessage setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}