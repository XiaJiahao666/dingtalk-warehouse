package com.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.entity.CustomerTicketEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerTicketDao extends BaseMapper<CustomerTicketEntity> {
}
