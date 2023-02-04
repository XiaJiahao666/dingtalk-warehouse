package com.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.dao.SupplierDao;
import com.modules.entity.SupplierEntity;
import com.modules.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierDao supplierDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(SupplierEntity supplier) {
        supplierDao.insert(supplier);
    }

    @Override
    public void deleteAll() {
        QueryWrapper<SupplierEntity> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 0);
        supplierDao.delete(wrapper);
    }
}
