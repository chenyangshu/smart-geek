package com.smartgeek.multisaas.adapter.driving.orgmng.persistence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 部门信息 持久化对象
 *
 * @author cys 2023-01-02 15:39:50
 */
@Data
@TableName("sys_dept")
public class SysDeptPo {

	private static final long serialVersionUID = 1L;

	/**
	 * 部门id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
    
	/**
	 * 父部门id
	 */
	private Long parentId;
    
	/**
	 * 部门编码
	 */
	private String code;
    
	/**
	 * 部门名称
	 */
	private String name;
    
	/**
	 * 树层级
	 */
	private Integer level;
    
	/**
	 * 祖级列表
	 */
	private String ancestors;
    
	/**
	 * 负责人
	 */
	private String leader;
    
	/**
	 * 联系电话
	 */
	private String phone;
    
	/**
	 * 邮箱
	 */
	private String email;
    
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