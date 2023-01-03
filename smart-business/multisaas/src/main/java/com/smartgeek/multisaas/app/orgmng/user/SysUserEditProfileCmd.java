package com.smartgeek.multisaas.app.orgmng.user;

import com.alibaba.cola.dto.Command;
import lombok.Data;

/**
 * 用户信息 持久化对象
 *
 * @author cys 2023-01-02 15:39:51
 */
@Data
public class SysUserEditProfileCmd extends Command {

    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    private Long id;


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
     * 个人简介
     */
    private String profile;


}
