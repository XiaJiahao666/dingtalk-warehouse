package com.modules.customer.controller;

import com.modules.customer.entity.CustomerEntity;
import com.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public List<CustomerEntity> queryList() {
        return customerService.queryList();
    }
}
