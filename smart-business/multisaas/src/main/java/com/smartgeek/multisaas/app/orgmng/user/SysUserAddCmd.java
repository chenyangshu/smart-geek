package com.smartgeek.multisaas.app.orgmng.user;

import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * 用户信息 持久化对象
 *
 * @author cys 2023-01-02 15:39:51
 */
@Data
public class SysUserAddCmd extends Command {
	private static final long serialVersionUID = 1L;

    
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
	 * 密码
	 */
	private String password;

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


}
