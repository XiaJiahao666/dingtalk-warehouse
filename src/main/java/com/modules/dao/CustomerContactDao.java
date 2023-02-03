package com.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.entity.CustomerContactEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerContactDao extends BaseMapper<CustomerContactEntity> {
}
