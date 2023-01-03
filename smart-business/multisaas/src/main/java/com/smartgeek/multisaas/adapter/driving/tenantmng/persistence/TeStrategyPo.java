package com.smartgeek.multisaas.adapter.driving.tenantmng.persistence;

import com.baomidou.mybatisplus.annotation.*;


import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;

/**
 * 数据源策略表
 *
 * @author cys 2023-01-02 15:49:51
 */
@Data
@TableName("te_strategy")
public class TeStrategyPo {

	private static final long serialVersionUID = 1L;

	/**
	 * 策略Id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
    
	/**
	 * 策略名称
	 */
	private String name;
    
	/**
	 * 数据源Id
	 */
	private Long sourceId;
    
	/**
	 * 数据源编码
	 */
	private String sourceSlave;
    
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
	 * 默认策略（Y是 N否）
	 */
	private String isDefault;
    
	/**
	 * 删除标志（0正常 1删除）
	 */
	private Integer delFlag;
    

}