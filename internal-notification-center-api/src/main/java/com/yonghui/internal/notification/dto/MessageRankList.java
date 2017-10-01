package com.yonghui.internal.notification.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * Description:渠道队列
 *
 * @Author: chenjie
 * @Date: 2017-07-31 18:38
 */
@Data
@NoArgsConstructor
public class MessageRankList implements Serializable{

    private List<MessageRank> messageRankList;
}
