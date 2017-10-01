package com.yonghui.internal.notification.model;

public class NotificationSend {
    private Long sendId;

    private Long messageId;

    private Long channelId;

    private String sendMessageState;

    private String sendState;

    private String sendReadReport;

    private String sendReceiverAddress;

    private String sendExtraMessage;

    private String sendAddress;

    private Integer sendRetryNum;

    private String sendPrepareTime;

    private String sendTime;

    private String sendReportTime;

    private Boolean sendCoefficient;

    private Boolean sendSetRetryNum;

    private Integer createUser;

    private String createTime;

    private Integer updateUser;

    private String updateTime;

    private String lastUpdateTime;

    public Long getSendId() {
        return sendId;
    }

    public NotificationSend setSendId(Long sendId) {
        this.sendId = sendId;
        return this;
    }

    public Long getMessageId() {
        return messageId;
    }

    public NotificationSend setMessageId(Long messageId) {
        this.messageId = messageId;
        return this;
    }

    public Long getChannelId() {
        return channelId;
    }

    public NotificationSend setChannelId(Long channelId) {
        this.channelId = channelId;
        return this;
    }

    public String getSendMessageState() {
        return sendMessageState;
    }

    public NotificationSend setSendMessageState(String sendMessageState) {
        this.sendMessageState = sendMessageState;
        return this;
    }

    public String getSendState() {
        return sendState;
    }

    public NotificationSend setSendState(String sendState) {
        this.sendState = sendState;
        return this;
    }

    public String getSendReadReport() {
        return sendReadReport;
    }

    public NotificationSend setSendReadReport(String sendReadReport) {
        this.sendReadReport = sendReadReport;
        return this;
    }

    public String getSendReceiverAddress() {
        return sendReceiverAddress;
    }

    public NotificationSend setSendReceiverAddress(String sendReceiverAddress) {
        this.sendReceiverAddress = sendReceiverAddress;
        return this;
    }

    public String getSendExtraMessage() {
        return sendExtraMessage;
    }

    public NotificationSend setSendExtraMessage(String sendExtraMessage) {
        this.sendExtraMessage = sendExtraMessage;
        return this;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public NotificationSend setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
        return this;
    }

    public Integer getSendRetryNum() {
        return sendRetryNum;
    }

    public NotificationSend setSendRetryNum(Integer sendRetryNum) {
        this.sendRetryNum = sendRetryNum;
        return this;
    }

    public String getSendPrepareTime() {
        return sendPrepareTime;
    }

    public NotificationSend setSendPrepareTime(String sendPrepareTime) {
        this.sendPrepareTime = sendPrepareTime;
        return this;
    }

    public String getSendTime() {
        return sendTime;
    }

    public NotificationSend setSendTime(String sendTime) {
        this.sendTime = sendTime;
        return this;
    }

    public String getSendReportTime() {
        return sendReportTime;
    }

    public NotificationSend setSendReportTime(String sendReportTime) {
        this.sendReportTime = sendReportTime;
        return this;
    }

    public Boolean getSendCoefficient() {
        return sendCoefficient;
    }

    public NotificationSend setSendCoefficient(Boolean sendCoefficient) {
        this.sendCoefficient = sendCoefficient;
        return this;
    }

    public Boolean getSendSetRetryNum() {
        return sendSetRetryNum;
    }

    public NotificationSend setSendSetRetryNum(Boolean sendSetRetryNum) {
        this.sendSetRetryNum = sendSetRetryNum;
        return this;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public NotificationSend setCreateUser(Integer createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getCreateTime() {
        return createTime;
    }

    public NotificationSend setCreateTime(String createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public NotificationSend setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
        return this;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public NotificationSend setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public NotificationSend setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        return this;
    }
}