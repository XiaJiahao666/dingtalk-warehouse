package com.modules.entity;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

@Data
@TableName(value = "rz_supplier", autoResultMap = true)
public class SupplierEntity {

    @TableId
    private Long id;

    /**
     * 编号
     */
    private String number;

    /**
     * 供应商名称
     */
    private String name;

    /**
     * 服务商状态
     */
    private String status;

    /**
     * 供应商地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contactName;

    /**
     * 开户资料
     */
    @TableField(typeHandler = FastjsonTypeHandler.class)
    private JSONArray attachment;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 逻辑删除标志 1.删除
     */
    @TableLogic
    private Boolean delFlag;
}
