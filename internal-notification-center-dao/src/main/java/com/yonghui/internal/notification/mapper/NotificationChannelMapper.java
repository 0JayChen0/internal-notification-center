package com.yonghui.internal.notification.mapper;

import com.yonghui.internal.notification.model.NotificationChannel;
import com.yonghui.internal.notification.model.NotificationChannelExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface NotificationChannelMapper {
    int deleteByExample(NotificationChannelExample example);

    int deleteByPrimaryKey(Long channelId);

    int insert(NotificationChannel record);

    int insertSelective(NotificationChannel record);

    List<NotificationChannel> selectByExample(NotificationChannelExample example);

    NotificationChannel selectByPrimaryKey(Long channelId);

    int updateByExampleSelective(@Param("record") NotificationChannel record, @Param("example") NotificationChannelExample example);

    int updateByExample(@Param("record") NotificationChannel record, @Param("example") NotificationChannelExample example);

    int updateByPrimaryKeySelective(NotificationChannel record);

    int updateByPrimaryKey(NotificationChannel record);
}