package com.modules.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.modules.dao.CustomerDao;
import com.modules.entity.CustomerContactEntity;
import com.modules.entity.CustomerEntity;
import com.modules.entity.CustomerTicketEntity;
import com.modules.service.CustomerContactService;
import com.modules.service.CustomerService;
import com.modules.service.CustomerTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerContactService customerContactService;

    @Autowired
    private CustomerTicketService customerTicketService;

    @Override
    public List<CustomerEntity> selectList() {
        List<CustomerEntity> customerList = customerDao.selectList(new QueryWrapper<>());
        customerList.forEach(customer -> {
            // 查询联系人信息
            List<CustomerContactEntity> customerContactList = customerContactService.queryListByCustomerId(customer.getId());
            customer.setCustomerContactList(customerContactList);
            // 查询开票信息
            List<CustomerTicketEntity> customerTicketList = customerTicketService.queryListByCustomerId(customer.getId());
            customer.setCustomerTicketList(customerTicketList);
        });
        return customerList;
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
