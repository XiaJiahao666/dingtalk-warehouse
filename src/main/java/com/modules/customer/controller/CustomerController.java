package com.modules.customer.controller;

import com.common.R;
import com.modules.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("list")
    public R queryList() {
        return R.ok(customerService.selectList());
    }
}
