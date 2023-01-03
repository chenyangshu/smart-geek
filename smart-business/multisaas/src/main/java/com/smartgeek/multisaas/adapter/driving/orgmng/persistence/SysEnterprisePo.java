package com.smartgeek.multisaas.adapter.driving.orgmng.persistence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 企业 持久化对象
 *
 * @author treeyschen
 * @date 2023/01/02
 */
@Data
@TableName("te_tenant")
public class SysEnterprisePo {
    private static final long serialVersionUID = 1L;

    /**
     * 租户Id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 策略Id
     */
    private Long strategyId;

    /**
     * 租户账号
     */
    private String name;

    /**
     * 系统名称
     */
    private String systemName;

    /**
     * 租户名称
     */
    private String nick;

    /**
     * 租户logo
     */
    private String logo;

    /**
     * 账号修改次数
     */
    private Integer nameFrequency;

    /**
     * 超管租户（Y是 N否）
     */
    private String isLessor;

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
     * 默认租户（Y是 N否）
     */
    private String isDefault;

    /**
     * 删除标志（0正常 1删除）
     */
    private Integer delFlag;
}
