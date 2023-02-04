package com.modules.controller;

import com.common.R;
import com.modules.scheduler.CustomerTask;
import com.modules.scheduler.SupplierTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("task")
public class TaskController {

    private final CustomerTask customerTask;

    private final SupplierTask supplierTask;

    @Autowired
    public TaskController(CustomerTask customerTask, SupplierTask supplierTask) {
        this.customerTask = customerTask;
        this.supplierTask = supplierTask;
    }

    @GetMapping("customer-task")
    public R customerTask() {
        customerTask.run(new HashMap<>(0));
        return R.ok();
    }

    @GetMapping("supplier-task")
    public R supplierTask() {
        supplierTask.run(new HashMap<>(0));
        return R.ok();
    }
}
