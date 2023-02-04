package com.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.dao.WarehouseDao;
import com.modules.entity.WarehouseEntity;
import com.modules.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseDao warehouseDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(WarehouseEntity warehouse) {
        warehouseDao.insert(warehouse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll() {
        QueryWrapper<WarehouseEntity> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 0);
        warehouseDao.delete(wrapper);
    }
}
