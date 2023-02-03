package com.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {

}