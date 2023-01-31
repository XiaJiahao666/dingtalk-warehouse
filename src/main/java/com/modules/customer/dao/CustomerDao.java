package com.modules.customer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.customer.entity.CustomerEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerDao extends BaseMapper<CustomerEntity> {

    @Select("select * from rz_customer")
    List<CustomerEntity> queryList();
}