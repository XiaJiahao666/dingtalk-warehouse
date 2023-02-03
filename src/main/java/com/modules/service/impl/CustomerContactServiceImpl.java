package com.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.dao.CustomerContactDao;
import com.modules.entity.CustomerContactEntity;
import com.modules.service.CustomerContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerContactServiceImpl implements CustomerContactService {

    @Autowired
    private CustomerContactDao customerContactDao;

    @Override
    public List<CustomerContactEntity> queryListByCustomerId(Long customerId) {
        QueryWrapper<CustomerContactEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id", customerId);
        return customerContactDao.selectList(wrapper);
    }

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
