package com.modules.customer.service;

import com.modules.customer.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {

    /**
     * 查询所有数据
     */
    List<CustomerEntity> selectList();

    /**
     * 新增
     */
    void insert(CustomerEntity customer);

    /**
     * 删除所有数据
     */
    void deleteAll();
}
