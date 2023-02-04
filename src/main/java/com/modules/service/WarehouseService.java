package com.modules.service;

import com.modules.entity.SupplierEntity;
import com.modules.entity.WarehouseEntity;

public interface WarehouseService {

    /**
     * 新增
     */
    void insert(WarehouseEntity warehouse);

    /**
     * 删除所有数据
     */
    void deleteAll();
}
