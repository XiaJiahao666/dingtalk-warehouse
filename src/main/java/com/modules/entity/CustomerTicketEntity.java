package com.modules.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("rz_customer_ticket")
public class CustomerTicketEntity {

    @TableId
    private Long id;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 纳税人识别号
     */
    private String number;

    /**
     * 注册地址
     */
    private String address;

    /**
     * 电话
     */
    private String mobile;

    /**
     * 银行账号
     */
    private String bankAccount;

    /**
     * 开户银行
     */
    private String bank;

    /**
     * 逻辑删除标志 1.删除
     */
    @TableLogic
    private Boolean delFlag;
}
