package com.yonghui.internal.notification.model;

import java.util.ArrayList;
import java.util.List;

public class NotificationSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationSendExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSendIdIsNull() {
            addCriterion("send_id is null");
            return (Criteria) this;
        }

        public Criteria andSendIdIsNotNull() {
            addCriterion("send_id is not null");
            return (Criteria) this;
        }

        public Criteria andSendIdEqualTo(Long value) {
            addCriterion("send_id =", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotEqualTo(Long value) {
            addCriterion("send_id <>", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThan(Long value) {
            addCriterion("send_id >", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdGreaterThanOrEqualTo(Long value) {
            addCriterion("send_id >=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThan(Long value) {
            addCriterion("send_id <", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdLessThanOrEqualTo(Long value) {
            addCriterion("send_id <=", value, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdIn(List<Long> values) {
            addCriterion("send_id in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotIn(List<Long> values) {
            addCriterion("send_id not in", values, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdBetween(Long value1, Long value2) {
            addCriterion("send_id between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andSendIdNotBetween(Long value1, Long value2) {
            addCriterion("send_id not between", value1, value2, "sendId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Long value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Long value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Long value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Long value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Long> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Long> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Long value1, Long value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateIsNull() {
            addCriterion("send_message_state is null");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateIsNotNull() {
            addCriterion("send_message_state is not null");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateEqualTo(String value) {
            addCriterion("send_message_state =", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateNotEqualTo(String value) {
            addCriterion("send_message_state <>", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateGreaterThan(String value) {
            addCriterion("send_message_state >", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateGreaterThanOrEqualTo(String value) {
            addCriterion("send_message_state >=", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateLessThan(String value) {
            addCriterion("send_message_state <", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateLessThanOrEqualTo(String value) {
            addCriterion("send_message_state <=", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateLike(String value) {
            addCriterion("send_message_state like", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateNotLike(String value) {
            addCriterion("send_message_state not like", value, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateIn(List<String> values) {
            addCriterion("send_message_state in", values, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateNotIn(List<String> values) {
            addCriterion("send_message_state not in", values, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateBetween(String value1, String value2) {
            addCriterion("send_message_state between", value1, value2, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendMessageStateNotBetween(String value1, String value2) {
            addCriterion("send_message_state not between", value1, value2, "sendMessageState");
            return (Criteria) this;
        }

        public Criteria andSendStateIsNull() {
            addCriterion("send_state is null");
            return (Criteria) this;
        }

        public Criteria andSendStateIsNotNull() {
            addCriterion("send_state is not null");
            return (Criteria) this;
        }

        public Criteria andSendStateEqualTo(String value) {
            addCriterion("send_state =", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotEqualTo(String value) {
            addCriterion("send_state <>", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateGreaterThan(String value) {
            addCriterion("send_state >", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateGreaterThanOrEqualTo(String value) {
            addCriterion("send_state >=", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLessThan(String value) {
            addCriterion("send_state <", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLessThanOrEqualTo(String value) {
            addCriterion("send_state <=", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateLike(String value) {
            addCriterion("send_state like", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotLike(String value) {
            addCriterion("send_state not like", value, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateIn(List<String> values) {
            addCriterion("send_state in", values, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotIn(List<String> values) {
            addCriterion("send_state not in", values, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateBetween(String value1, String value2) {
            addCriterion("send_state between", value1, value2, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendStateNotBetween(String value1, String value2) {
            addCriterion("send_state not between", value1, value2, "sendState");
            return (Criteria) this;
        }

        public Criteria andSendReadReportIsNull() {
            addCriterion("send_read_report is null");
            return (Criteria) this;
        }

        public Criteria andSendReadReportIsNotNull() {
            addCriterion("send_read_report is not null");
            return (Criteria) this;
        }

        public Criteria andSendReadReportEqualTo(String value) {
            addCriterion("send_read_report =", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportNotEqualTo(String value) {
            addCriterion("send_read_report <>", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportGreaterThan(String value) {
            addCriterion("send_read_report >", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportGreaterThanOrEqualTo(String value) {
            addCriterion("send_read_report >=", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportLessThan(String value) {
            addCriterion("send_read_report <", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportLessThanOrEqualTo(String value) {
            addCriterion("send_read_report <=", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportLike(String value) {
            addCriterion("send_read_report like", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportNotLike(String value) {
            addCriterion("send_read_report not like", value, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportIn(List<String> values) {
            addCriterion("send_read_report in", values, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportNotIn(List<String> values) {
            addCriterion("send_read_report not in", values, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportBetween(String value1, String value2) {
            addCriterion("send_read_report between", value1, value2, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReadReportNotBetween(String value1, String value2) {
            addCriterion("send_read_report not between", value1, value2, "sendReadReport");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressIsNull() {
            addCriterion("send_receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressIsNotNull() {
            addCriterion("send_receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressEqualTo(String value) {
            addCriterion("send_receiver_address =", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressNotEqualTo(String value) {
            addCriterion("send_receiver_address <>", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressGreaterThan(String value) {
            addCriterion("send_receiver_address >", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("send_receiver_address >=", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressLessThan(String value) {
            addCriterion("send_receiver_address <", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("send_receiver_address <=", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressLike(String value) {
            addCriterion("send_receiver_address like", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressNotLike(String value) {
            addCriterion("send_receiver_address not like", value, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressIn(List<String> values) {
            addCriterion("send_receiver_address in", values, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressNotIn(List<String> values) {
            addCriterion("send_receiver_address not in", values, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressBetween(String value1, String value2) {
            addCriterion("send_receiver_address between", value1, value2, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("send_receiver_address not between", value1, value2, "sendReceiverAddress");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageIsNull() {
            addCriterion("send_extra_message is null");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageIsNotNull() {
            addCriterion("send_extra_message is not null");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageEqualTo(String value) {
            addCriterion("send_extra_message =", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageNotEqualTo(String value) {
            addCriterion("send_extra_message <>", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageGreaterThan(String value) {
            addCriterion("send_extra_message >", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageGreaterThanOrEqualTo(String value) {
            addCriterion("send_extra_message >=", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageLessThan(String value) {
            addCriterion("send_extra_message <", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageLessThanOrEqualTo(String value) {
            addCriterion("send_extra_message <=", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageLike(String value) {
            addCriterion("send_extra_message like", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageNotLike(String value) {
            addCriterion("send_extra_message not like", value, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageIn(List<String> values) {
            addCriterion("send_extra_message in", values, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageNotIn(List<String> values) {
            addCriterion("send_extra_message not in", values, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageBetween(String value1, String value2) {
            addCriterion("send_extra_message between", value1, value2, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendExtraMessageNotBetween(String value1, String value2) {
            addCriterion("send_extra_message not between", value1, value2, "sendExtraMessage");
            return (Criteria) this;
        }

        public Criteria andSendAddressIsNull() {
            addCriterion("send_address is null");
            return (Criteria) this;
        }

        public Criteria andSendAddressIsNotNull() {
            addCriterion("send_address is not null");
            return (Criteria) this;
        }

        public Criteria andSendAddressEqualTo(String value) {
            addCriterion("send_address =", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotEqualTo(String value) {
            addCriterion("send_address <>", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressGreaterThan(String value) {
            addCriterion("send_address >", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressGreaterThanOrEqualTo(String value) {
            addCriterion("send_address >=", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressLessThan(String value) {
            addCriterion("send_address <", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressLessThanOrEqualTo(String value) {
            addCriterion("send_address <=", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressLike(String value) {
            addCriterion("send_address like", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotLike(String value) {
            addCriterion("send_address not like", value, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressIn(List<String> values) {
            addCriterion("send_address in", values, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotIn(List<String> values) {
            addCriterion("send_address not in", values, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressBetween(String value1, String value2) {
            addCriterion("send_address between", value1, value2, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendAddressNotBetween(String value1, String value2) {
            addCriterion("send_address not between", value1, value2, "sendAddress");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumIsNull() {
            addCriterion("send_retry_num is null");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumIsNotNull() {
            addCriterion("send_retry_num is not null");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumEqualTo(Integer value) {
            addCriterion("send_retry_num =", value, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumNotEqualTo(Integer value) {
            addCriterion("send_retry_num <>", value, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumGreaterThan(Integer value) {
            addCriterion("send_retry_num >", value, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("send_retry_num >=", value, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumLessThan(Integer value) {
            addCriterion("send_retry_num <", value, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumLessThanOrEqualTo(Integer value) {
            addCriterion("send_retry_num <=", value, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumIn(List<Integer> values) {
            addCriterion("send_retry_num in", values, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumNotIn(List<Integer> values) {
            addCriterion("send_retry_num not in", values, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumBetween(Integer value1, Integer value2) {
            addCriterion("send_retry_num between", value1, value2, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendRetryNumNotBetween(Integer value1, Integer value2) {
            addCriterion("send_retry_num not between", value1, value2, "sendRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeIsNull() {
            addCriterion("send_prepare_time is null");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeIsNotNull() {
            addCriterion("send_prepare_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeEqualTo(String value) {
            addCriterion("send_prepare_time =", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeNotEqualTo(String value) {
            addCriterion("send_prepare_time <>", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeGreaterThan(String value) {
            addCriterion("send_prepare_time >", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeGreaterThanOrEqualTo(String value) {
            addCriterion("send_prepare_time >=", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeLessThan(String value) {
            addCriterion("send_prepare_time <", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeLessThanOrEqualTo(String value) {
            addCriterion("send_prepare_time <=", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeLike(String value) {
            addCriterion("send_prepare_time like", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeNotLike(String value) {
            addCriterion("send_prepare_time not like", value, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeIn(List<String> values) {
            addCriterion("send_prepare_time in", values, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeNotIn(List<String> values) {
            addCriterion("send_prepare_time not in", values, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeBetween(String value1, String value2) {
            addCriterion("send_prepare_time between", value1, value2, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendPrepareTimeNotBetween(String value1, String value2) {
            addCriterion("send_prepare_time not between", value1, value2, "sendPrepareTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(String value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(String value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(String value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(String value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(String value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(String value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLike(String value) {
            addCriterion("send_time like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotLike(String value) {
            addCriterion("send_time not like", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<String> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<String> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(String value1, String value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(String value1, String value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeIsNull() {
            addCriterion("send_report_time is null");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeIsNotNull() {
            addCriterion("send_report_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeEqualTo(String value) {
            addCriterion("send_report_time =", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeNotEqualTo(String value) {
            addCriterion("send_report_time <>", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeGreaterThan(String value) {
            addCriterion("send_report_time >", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeGreaterThanOrEqualTo(String value) {
            addCriterion("send_report_time >=", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeLessThan(String value) {
            addCriterion("send_report_time <", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeLessThanOrEqualTo(String value) {
            addCriterion("send_report_time <=", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeLike(String value) {
            addCriterion("send_report_time like", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeNotLike(String value) {
            addCriterion("send_report_time not like", value, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeIn(List<String> values) {
            addCriterion("send_report_time in", values, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeNotIn(List<String> values) {
            addCriterion("send_report_time not in", values, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeBetween(String value1, String value2) {
            addCriterion("send_report_time between", value1, value2, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendReportTimeNotBetween(String value1, String value2) {
            addCriterion("send_report_time not between", value1, value2, "sendReportTime");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientIsNull() {
            addCriterion("send_coefficient is null");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientIsNotNull() {
            addCriterion("send_coefficient is not null");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientEqualTo(Boolean value) {
            addCriterion("send_coefficient =", value, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientNotEqualTo(Boolean value) {
            addCriterion("send_coefficient <>", value, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientGreaterThan(Boolean value) {
            addCriterion("send_coefficient >", value, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientGreaterThanOrEqualTo(Boolean value) {
            addCriterion("send_coefficient >=", value, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientLessThan(Boolean value) {
            addCriterion("send_coefficient <", value, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientLessThanOrEqualTo(Boolean value) {
            addCriterion("send_coefficient <=", value, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientIn(List<Boolean> values) {
            addCriterion("send_coefficient in", values, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientNotIn(List<Boolean> values) {
            addCriterion("send_coefficient not in", values, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientBetween(Boolean value1, Boolean value2) {
            addCriterion("send_coefficient between", value1, value2, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendCoefficientNotBetween(Boolean value1, Boolean value2) {
            addCriterion("send_coefficient not between", value1, value2, "sendCoefficient");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumIsNull() {
            addCriterion("send_set_retry_num is null");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumIsNotNull() {
            addCriterion("send_set_retry_num is not null");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumEqualTo(Boolean value) {
            addCriterion("send_set_retry_num =", value, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumNotEqualTo(Boolean value) {
            addCriterion("send_set_retry_num <>", value, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumGreaterThan(Boolean value) {
            addCriterion("send_set_retry_num >", value, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumGreaterThanOrEqualTo(Boolean value) {
            addCriterion("send_set_retry_num >=", value, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumLessThan(Boolean value) {
            addCriterion("send_set_retry_num <", value, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumLessThanOrEqualTo(Boolean value) {
            addCriterion("send_set_retry_num <=", value, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumIn(List<Boolean> values) {
            addCriterion("send_set_retry_num in", values, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumNotIn(List<Boolean> values) {
            addCriterion("send_set_retry_num not in", values, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumBetween(Boolean value1, Boolean value2) {
            addCriterion("send_set_retry_num between", value1, value2, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andSendSetRetryNumNotBetween(Boolean value1, Boolean value2) {
            addCriterion("send_set_retry_num not between", value1, value2, "sendSetRetryNum");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Integer value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Integer value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Integer value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Integer value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Integer value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Integer> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Integer> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Integer value1, Integer value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(String value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(String value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(String value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(String value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLike(String value) {
            addCriterion("last_update_time like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotLike(String value) {
            addCriterion("last_update_time not like", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<String> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<String> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(String value1, String value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}