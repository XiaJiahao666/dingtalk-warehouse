package com.modules.customer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.customer.dao.CustomerTicketDao;
import com.modules.customer.entity.CustomerTicketEntity;
import com.modules.customer.service.CustomerTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerTicketServiceImpl implements CustomerTicketService {

    @Autowired
    private CustomerTicketDao customerTicketDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(CustomerTicketEntity customerTicket) {
        customerTicketDao.insert(customerTicket);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll() {
        QueryWrapper<CustomerTicketEntity> wrapper = new QueryWrapper<>();
        wrapper.gt("id", 0);
        customerTicketDao.delete(wrapper);
    }
}
