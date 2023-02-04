package com.modules.service;

import com.modules.entity.SupplierEntity;

import java.util.List;

public interface SupplierService {

    /**
     * 新增
     */
    void insert(SupplierEntity supplier);

    /**
     * 删除所有数据
     */
    void deleteAll();
}
