package com.smartgeek.multisaas.adapter.driving.authmng.persistence;

import com.baomidou.mybatisplus.annotation.*;


import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;

/**
 * 模块信息表
 *
 * @author cys 2023-01-02 15:45:32
 */
@Data
@TableName("sys_module")
public class SysModulePo {

	private static final long serialVersionUID = 1L;

	/**
	 * 模块Id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
    
	/**
	 * 模块名称
	 */
	private String name;
    
	/**
	 * 模块logo
	 */
	private String logo;
    
	/**
	 * 路由地址
	 */
	private String path;
    
	/**
	 * 路由参数
	 */
	private String paramPath;
    
	/**
	 * 模块类型（0常规 1内嵌 2外链）
	 */
	private String type;
    
	/**
	 * 模块显隐状态（0显示 1隐藏）
	 */
	private String hideModule;
    
	/**
	 * 显示顺序
	 */
	private Integer sort;
    
	/**
	 * 状态（0正常 1停用）
	 */
	private String status;
    
	/**
	 * 备注
	 */
	private String remark;
    
	/**
	 * 创建者
	 */
	private Long createBy;
    
	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
    
	/**
	 * 更新者
	 */
	private Long updateBy;
    
	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;
    
	/**
	 * 公共模块（0公共 1私有）
	 */
	private String isCommon;
    
	/**
	 * 默认模块（Y是 N否）
	 */
	private String isDefault;
    
	/**
	 * 删除标志（0正常 1删除）
	 */
	private Integer delFlag;
    
	/**
	 * 租户Id
	 */
	private Long tenantId;
    

}