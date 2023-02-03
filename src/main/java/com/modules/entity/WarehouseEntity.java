package com.modules.entity;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("rz_warehouse")
public class WarehouseEntity {

    @TableId
    private Long id;

    /**
     * 仓库名称
     */
    private String name;

    /**
     * 产品编号
     */
    private String productNumber;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 规格
     */
    private String spec;

    /**
     * 分类名称
     */
    private String type;

    /**
     * 单位名称
     */
    private String unit;

    /**
     * 供应商
     */
    private String supplierName;

    /**
     * 库存数量
     */
    private BigDecimal anount;

    /**
     * 逻辑删除标志 1.删除
     */
    @TableLogic
    private Boolean delFlag;
}
