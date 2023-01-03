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
 * 用户信息 持久化对象
 *
 * @author cys 2023-01-02 15:39:51
 */
@Data
@TableName("sys_user")
public class SysUserPo {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户Id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
    
	/**
	 * 用户编码
	 */
	private String code;
    
	/**
	 * 用户账号
	 */
	private String userName;
    
	/**
	 * 用户昵称
	 */
	private String nickName;
    
	/**
	 * 用户类型（00超管用户 01普通用户）
	 */
	private String userType;
    
	/**
	 * 手机号码
	 */
	private String phone;
    
	/**
	 * 用户邮箱
	 */
	private String email;
    
	/**
	 * 用户性别（0男 1女 2保密）
	 */
	private String sex;
    
	/**
	 * 头像地址
	 */
	private String avatar;
    
	/**
	 * 个人简介
	 */
	private String profile;
    
	/**
	 * 密码
	 */
	private String password;
    
	/**
	 * 最后登录IP
	 */
	private String loginIp;
    
	/**
	 * 最后登录时间
	 */
	private LocalDateTime loginDate;
    
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
