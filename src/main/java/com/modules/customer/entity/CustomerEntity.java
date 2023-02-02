package com.modules.customer.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("rz_customer")
public class CustomerEntity {

    @TableId
    private Long id;

    /**
     * 客户名称
     */
    private String numbe;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户名称
     */
    private String rank;

    /**
     * 客户名称
     */
    private String address;

}
