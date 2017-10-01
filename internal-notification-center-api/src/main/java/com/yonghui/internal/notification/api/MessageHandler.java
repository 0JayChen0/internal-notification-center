package com.yonghui.internal.notification.api;

import com.yonghui.internal.notification.dto.AllMessageInfo;
import com.yonghui.internal.notification.dto.MessageRankList;
import com.yonghui.internal.notification.dto.MessageReturn;
import com.yonghui.internal.notification.dto.MessageType;
import com.yonghui.internal.notification.dto.ResultSet;
import com.yonghui.internal.notification.dto.SelectHistory;
import com.yonghui.internal.notification.dto.SendEmailInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Description:消息通知接口
 *
 * @Author: chenjie
 * @Date: 2017-07-24 09:18
 */
public interface MessageHandler {

    /**
     * 简单网页消息发送(失败重试3次，再失败不换渠道发送，普通文本，不发送已读回执)
     * @param messageText 消息内容
     * @param messageTo 消息接收人(多个用逗号隔开)
     * @return
     */
    @RequestMapping(value = "/sendSimpleWebMessage", method= RequestMethod.POST)
    boolean sendSimpleWebMessage(@RequestParam("messageText") String messageText,@RequestParam("messageTo") String messageTo);

    /**
     * 网页消息发送(失败重试3次，普通文本，需发送已读回执)
     * @param messageText 消息内容
     * @param messageTo 消息接收人(多个用逗号隔开)
     * @param messageTitle 消息标题
     * @param messageSendName 消息署名
     * @param messageRankList 消息发送渠道列表(不填代表失败不换渠道发送)
     * @return
     */
    @RequestMapping(value = "/sendWebMessageWithRead", method= RequestMethod.POST)
    List<ResultSet> sendWebMessageWithRead(@RequestParam("messageText") String messageText, @RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,@RequestParam("messageSendName") String messageSendName,@RequestBody MessageRankList messageRankList);

    /**
     * 网页消息发送(失败重试3次，普通文本，不需发送已读回执)
     * @param messageText 消息内容
     * @param messageTo 消息接收人(多个用逗号隔开)
     * @param messageTitle 消息标题
     * @param messageSendName 消息署名
     * @param messageRankList 消息发送渠道列表(不填代表失败不换渠道发送)
     * @return
     */
    @RequestMapping(value = "/sendWebMessageWithoutRead", method= RequestMethod.POST)
    List<ResultSet> sendWebMessageWithoutRead(@RequestParam("messageText") String messageText,@RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,@RequestParam("messageSendName") String messageSendName,
            @RequestBody MessageRankList messageRankList);

    /**
     * 简单的邮件发送(失败重试3次，再失败不换渠道发送，普通文本，不发送已读回执，无抄送，使用默认邮箱)
     * @param messageText 消息内容
     * @param messageTo 消息接收人(多个用逗号隔开)
     * @return
     */
    @RequestMapping(value = "/sendSimpleEmail", method= RequestMethod.POST)
    boolean sendSimpleEmail(@RequestParam("messageText") String messageText, @RequestParam("messageTo") String messageTo);

    /**
     * 邮件发送(失败重试3次，普通文本，不需发送已读回执，使用默认邮箱)
     * @param messageText 消息内容
     * @param messageTo 消息接收人(多个用逗号隔开)
     * @param messageTitle 消息标题
     * @param messageSendName 消息署名
     * @param messageCC 抄送人(多个用逗号隔开)
     * @param messageRankList 消息发送渠道列表(不填代表失败不换渠道发送)
     * @return
     */
    @RequestMapping(value = "/sendEmailWithoutRead", method= RequestMethod.POST)
    List<ResultSet> sendEmailWithoutRead(@RequestParam("messageText")String messageText,@RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,@RequestParam("messageSendName") String messageSendName,
            @RequestParam("messageCC") String messageCC,@RequestBody MessageRankList messageRankList);

    /**
     * 邮件发送(失败重试3次，普通文本，需发送已读回执，使用默认邮箱)
     * @param messageText 消息内容
     * @param messageTo 消息接收人(多个用逗号隔开)
     * @param messageTitle 消息标题
     * @param messageSendName 消息署名
     * @param messageCC 抄送人(多个用逗号隔开)
     * @param messageRankList 消息发送渠道列表(不填代表失败不换渠道发送)
     * @return
     */
    @RequestMapping(value = "/sendEmailWithRead", method= RequestMethod.POST)
    List<ResultSet> sendEmailWithRead(@RequestParam("messageText") String messageText,@RequestParam("messageTo") String messageTo,
            @RequestParam("messageTitle") String messageTitle,@RequestParam("messageSendName") String messageSendName,
            @RequestParam("messageCC") String messageCC,@RequestBody MessageRankList messageRankList);

    /**
     * 邮件发送(失败重试3次，普通文本，需发送已读回执，使用自定义邮箱)
     * @param sendEmailInfo 消息对象
     * @return
     */
    @RequestMapping(value = "/sendEmailWithReadForMailBox", method= RequestMethod.POST)
    List<ResultSet> sendEmailWithReadForMailBox(@RequestBody SendEmailInfo sendEmailInfo);

    /**
     * 邮件发送(失败重试3次，普通文本，不需发送已读回执，使用自定义邮箱)
     * @param sendEmailInfo 消息对象
     * @return
     */
    @RequestMapping(value = "/sendEmailWithReadForMailBox", method= RequestMethod.POST)
    List<ResultSet> sendEmailWithoutReadForMailBox(@RequestBody SendEmailInfo sendEmailInfo);

    /**
     * 发送消息
     * @param allMessageInfo 完整消息请求对象
     * @return 返回消息各渠道发送状态列表
     */
    @RequestMapping(value = "/sendMessage", method= RequestMethod.POST)
    List<ResultSet> sendMessage(@RequestBody AllMessageInfo allMessageInfo);

    /**
     * 接收未读消息
     * @param toUser 消息接收人
     * @param messageType 消息类型
     * @param messageDate 查询开始时间
     * @return
     */
    @RequestMapping(value = "/getMessage", method= RequestMethod.POST)
    List<MessageReturn> getMessage(@RequestParam("toUser") String toUser,
            @RequestParam("messageType") MessageType messageType,@RequestParam("messageDate") String messageDate);

    /**
     * 通知消息已读
     * @param sendid 发送ID(多条消息用逗号隔开)
     * @return
     */
    @RequestMapping(value = "/messageIsRead", method= RequestMethod.POST)
    void messageIsRead(@RequestParam("sendid") String sendid);


    /**
     * 查询历史消息
     * @param selectHistory 查询参数类
     * @return
     */
    @RequestMapping(value = "/selectHistoryMessage", method= RequestMethod.POST)
    List<MessageReturn> selectHistoryMessage(@RequestBody SelectHistory selectHistory);
}
