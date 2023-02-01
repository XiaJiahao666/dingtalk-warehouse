package com.modules.task;

import com.modules.scheduler.CustomerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("task")
public class TaskController {

    private final CustomerTask customerTask;

    @Autowired
    public TaskController(CustomerTask customerTask) {
        this.customerTask = customerTask;
    }

    @GetMapping("customer-task")
    public void customerTask() {
        customerTask.run(new HashMap<>(0));
    }
}
