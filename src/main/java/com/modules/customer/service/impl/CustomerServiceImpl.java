package com.modules.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.customer.dao.CustomerDao;
import com.modules.customer.entity.CustomerEntity;
import com.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public List<CustomerEntity> selectList() {
        return customerDao.selectList(new QueryWrapper<>());
    }
}
