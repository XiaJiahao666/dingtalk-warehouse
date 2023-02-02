package com.modules.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.customer.dao.CustomerDao;
import com.modules.customer.entity.CustomerEntity;
import com.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<CustomerEntity> selectList() {
        return customerDao.selectList(new QueryWrapper<>());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(CustomerEntity customer) {
        customerDao.insert(customer);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll() {
        QueryWrapper<CustomerEntity> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 0);
        customerDao.delete(wrapper);
    }
}
