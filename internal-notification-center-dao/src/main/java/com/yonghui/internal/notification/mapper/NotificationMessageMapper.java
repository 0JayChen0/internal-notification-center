package com.yonghui.internal.notification.mapper;

import com.yonghui.internal.notification.model.NotificationMessage;
import com.yonghui.internal.notification.model.NotificationMessageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface NotificationMessageMapper {
    int deleteByExample(NotificationMessageExample example);

    int deleteByPrimaryKey(Long messageId);

    int insert(NotificationMessage record);

    int insertSelective(NotificationMessage record);

    List<NotificationMessage> selectByExample(NotificationMessageExample example);

    NotificationMessage selectByPrimaryKey(Long messageId);

    int updateByExampleSelective(@Param("record") NotificationMessage record, @Param("example") NotificationMessageExample example);

    int updateByExample(@Param("record") NotificationMessage record, @Param("example") NotificationMessageExample example);

    int updateByPrimaryKeySelective(NotificationMessage record);

    int updateByPrimaryKey(NotificationMessage record);
}