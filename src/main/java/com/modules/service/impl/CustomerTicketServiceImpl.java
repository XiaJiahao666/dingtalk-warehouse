package com.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.dao.CustomerTicketDao;
import com.modules.entity.CustomerTicketEntity;
import com.modules.service.CustomerTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerTicketServiceImpl implements CustomerTicketService {

    @Autowired
    private CustomerTicketDao customerTicketDao;

    @Override
    public List<CustomerTicketEntity> queryListByCustomerId(Long customerId) {
        QueryWrapper<CustomerTicketEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("customer_id", customerId);
        return customerTicketDao.selectList(wrapper);
    }

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
