package com.smartgeek.multisaas.app.orgmng.post;


import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * 岗位信息 持久化对象
 *
 * @author cys 2023-01-02 15:39:51
 */
@Data
public class SysPostEditCmd  extends Command {

	private static final long serialVersionUID = 1L;

	/**
	 * 岗位Id
	 */
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
	 * 租户Id
	 */
	private Long tenantId;
    

}