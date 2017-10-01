package com.yonghui.internal.notification.mapper;

import com.yonghui.internal.notification.model.NotificationSend;
import com.yonghui.internal.notification.model.NotificationSendExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface NotificationSendMapper {
    int deleteByExample(NotificationSendExample example);

    int deleteByPrimaryKey(Long sendId);

    int insert(NotificationSend record);

    int insertSelective(NotificationSend record);

    List<NotificationSend> selectByExample(NotificationSendExample example);

    NotificationSend selectByPrimaryKey(Long sendId);

    int updateByExampleSelective(@Param("record") NotificationSend record, @Param("example") NotificationSendExample example);

    int updateByExample(@Param("record") NotificationSend record, @Param("example") NotificationSendExample example);

    int updateByPrimaryKeySelective(NotificationSend record);

    int updateByPrimaryKey(NotificationSend record);
}