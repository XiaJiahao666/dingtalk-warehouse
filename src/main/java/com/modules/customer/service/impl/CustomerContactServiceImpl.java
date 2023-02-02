package com.modules.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.customer.dao.CustomerContactDao;
import com.modules.customer.entity.CustomerContactEntity;
import com.modules.customer.service.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    @Autowired
    private CustomerContactDao customerContactDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(CustomerContactEntity customerContact) {
        customerContactDao.insert(customerContact);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll() {
        QueryWrapper<CustomerContactEntity> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 0);
        customerContactDao.delete(wrapper);
    }
}
