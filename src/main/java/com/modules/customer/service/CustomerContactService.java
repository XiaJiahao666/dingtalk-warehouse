package com.modules.customer.service;

import com.modules.customer.entity.CustomerContactEntity;

import java.util.List;

public interface CustomerContactService {

    /**
     * 根据客户id查询
     */
    List<CustomerContactEntity> queryListByCustomerId(Long customerId);

    /**
     * 新增
     */
    void insert(CustomerContactEntity customerContact);

    /**
     * 删除所有数据
     */
    void deleteAll();
}
