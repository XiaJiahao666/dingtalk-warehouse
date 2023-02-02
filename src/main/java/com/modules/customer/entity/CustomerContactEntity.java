package com.modules.customer.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("rz_customer_contact")
public class CustomerContactEntity {

    @TableId
    private Long id;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 联系方式
     */
    private String contactMobile;

    /**
     * 逻辑删除标志 1.删除
     */
    @TableLogic
    private Boolean delFlag;
}
