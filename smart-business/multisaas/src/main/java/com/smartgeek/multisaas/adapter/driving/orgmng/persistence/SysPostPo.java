package com.smartgeek.multisaas.adapter.driving.orgmng.persistence;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;
/**
 * 岗位信息 持久化对象
 *
 * @author cys 2023-01-02 15:39:51
 */
@Data
@TableName("sys_post")
public class SysPostPo {

	private static final long serialVersionUID = 1L;

	/**
	 * 岗位Id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
    
	/**
	 * 部门Id
	 */
	private Long deptId;
    
	/**
	 * 岗位编码
	 */
	private String code;
    
	/**
	 * 岗位名称
	 */
	private String name;
    
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
	 * 删除标志(0正常 1删除)
	 */
	private Integer delFlag;
    
	/**
	 * 租户Id
	 */
	private Long tenantId;
    

}