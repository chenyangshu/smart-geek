package com.smartgeek.multisaas.adapter.driving.authmng.persistence;

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
 * 角色信息表
 *
 * @author cys 2023-01-02 15:39:51
 */
@Data
@TableName("sys_role")
public class SysRolePo {

	private static final long serialVersionUID = 1L;

	/**
	 * 角色Id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
    
	/**
	 * 角色编码
	 */
	private String code;
    
	/**
	 * 角色名称
	 */
	private String name;
    
	/**
	 * 角色权限字符串
	 */
	private String roleKey;
    
	/**
	 * 数据范围（1全部数据权限 2自定数据权限 3本部门数据权限 4本部门及以下数据权限 5本岗位数据权限  6仅本人数据权限）
	 */
	private String dataScope;
    
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
	 * 删除标志（0正常 1删除）
	 */
	private Integer delFlag;
    
	/**
	 * 租户Id
	 */
	private Long tenantId;
    

}