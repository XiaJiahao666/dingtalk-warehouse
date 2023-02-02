package com.modules.customer.service;

import com.modules.customer.entity.CustomerContactEntity;
import com.modules.customer.entity.CustomerTicketEntity;

public interface CustomerTicketService {

    /**
     * 新增
     */
    void insert(CustomerTicketEntity customerTicket);

    /**
     * 删除所有数据
     */
    void deleteAll();
}
