package com.modules.customer.service;

import com.modules.customer.entity.CustomerTicketEntity;

import java.util.List;

public interface CustomerTicketService {

    /**
     * 根据客户id查询
     */
    List<CustomerTicketEntity> queryListByCustomerId(Long customerId);

    /**
     * 新增
     */
    void insert(CustomerTicketEntity customerTicket);

    /**
     * 删除所有数据
     */
    void deleteAll();
}
