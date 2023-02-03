package com.modules.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.modules.entity.SupplierEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierDao extends BaseMapper<SupplierEntity> {
}
