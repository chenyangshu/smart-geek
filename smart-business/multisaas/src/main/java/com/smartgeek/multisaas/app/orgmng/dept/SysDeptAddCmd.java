package com.smartgeek.multisaas.app.orgmng.dept;

import com.alibaba.cola.dto.Command;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysDeptAddCmd extends Command {
    private static final long serialVersionUID = 1L;


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
}
