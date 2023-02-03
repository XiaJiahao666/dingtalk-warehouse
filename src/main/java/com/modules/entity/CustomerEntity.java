package com.modules.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

@Data
@TableName("rz_customer")
public class CustomerEntity {

    @TableId
    private Long id;

    /**
     * 客户名称
     */
    private String number;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 客户名称
     */
    private String grade;

    /**
     * 客户名称
     */
    private String address;

    /**
     * 逻辑删除标志 1.删除
     */
    @TableLogic
    private Boolean delFlag;

    /**
     * 联系人信息
     */
    @TableField(exist = false)
    public List<CustomerContactEntity> customerContactList;

    /**
     * 开票信息
     */
    @TableField(exist = false)
    public List<CustomerTicketEntity> customerTicketList;
}
