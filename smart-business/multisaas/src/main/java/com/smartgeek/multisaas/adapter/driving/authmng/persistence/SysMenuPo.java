package com.smartgeek.multisaas.adapter.driving.authmng.persistence;

import com.baomidou.mybatisplus.annotation.*;


import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.time.LocalTime;

/**
 * 菜单权限表
 *
 * @author cys 2023-01-02 15:45:32
 */
@Data
@TableName("sys_menu")
public class SysMenuPo {

	private static final long serialVersionUID = 1L;

	/**
	 * 菜单Id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
    
	/**
	 * 父菜单Id
	 */
	private Long parentId;
    
	/**
	 * 菜单名称
	 */
	private String name;
    
	/**
	 * 菜单标题 | 多语言
	 */
	private String title;
    
	/**
	 * 树层级
	 */
	private Integer level;
    
	/**
	 * 祖级列表
	 */
	private String ancestors;
    
	/**
	 * 路由地址
	 */
	private String path;
    
	/**
	 * 外链地址 | 仅页面类型为外链时生效
	 */
	private String frameSrc;
    
	/**
	 * 组件路径
	 */
	private String component;
    
	/**
	 * 路由参数
	 */
	private String paramPath;
    
	/**
	 * 路由切换动画
	 */
	private String transitionName;
    
	/**
	 * 是否忽略路由（Y是 N否）
	 */
	private String ignoreRoute;
    
	/**
	 * 是否缓存（Y是 N否）
	 */
	private String isCache;
    
	/**
	 * 是否固定标签（Y是 N否）
	 */
	private String isAffix;
    
	/**
	 * 是否禁用（Y是 N否）
	 */
	private String isDisabled;
    
	/**
	 * 页面类型（0常规 1内嵌 2外链）
	 */
	private String frameType;
    
	/**
	 * 菜单类型（M目录 C菜单 X详情 F按钮）
	 */
	private String menuType;
    
	/**
	 * 标签显隐状态（0显示 1隐藏）
	 */
	private String hideTab;
    
	/**
	 * 菜单显隐状态（0显示 1隐藏）
	 */
	private String hideMenu;
    
	/**
	 * 面包屑路由显隐状态（0显示 1隐藏）
	 */
	private String hideBreadcrumb;
    
	/**
	 * 子菜单显隐状态（0显示 1隐藏）
	 */
	private String hideChildren;
    
	/**
	 * 是否在子级菜单的完整path中忽略本级path（0显示 1隐藏）
	 */
	private String hidePathForChildren;
    
	/**
	 * 详情页可打开Tab页数
	 */
	private Integer dynamicLevel;
    
	/**
	 * 详情页的实际Path
	 */
	private String realPath;
    
	/**
	 * 权限标识
	 */
	private String perms;
    
	/**
	 * 菜单图标
	 */
	private String icon;
    
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
	 * 公共菜单（0公共 1私有）
	 */
	private String isCommon;
    
	/**
	 * 默认菜单（Y是 N否）
	 */
	private String isDefault;
    
	/**
	 * 删除标志(0正常 1删除)
	 */
	private Integer delFlag;
    
	/**
	 * 模块Id
	 */
	private Long moduleId;
    
	/**
	 * 租户Id
	 */
	private Long tenantId;
    

}
