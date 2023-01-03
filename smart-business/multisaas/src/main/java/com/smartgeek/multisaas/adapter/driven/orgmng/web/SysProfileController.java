package com.smartgeek.multisaas.adapter.driven.orgmng.web;

import com.alibaba.cola.dto.Response;
import com.smartgeek.multisaas.app.orgmng.user.SysUserEditPasswordCmd;
import com.smartgeek.multisaas.app.orgmng.user.SysUserEditPasswordCmdExe;
import com.smartgeek.multisaas.app.orgmng.user.SysUserEditProfileCmd;
import com.smartgeek.multisaas.app.orgmng.user.SysUserEditProfileCmdExe;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/profile")
public class SysProfileController {

    @Resource
    private SysUserEditProfileCmdExe sysUserEditProfileCmdExe;

    @Resource
    private SysUserEditPasswordCmdExe sysUserEditPasswordCmdExe;


    /**
     * 修改用户
     */
    @PutMapping
    public Response editProfile(@Validated @RequestBody SysUserEditProfileCmd cmd) {
        return sysUserEditProfileCmdExe.execute(cmd);
    }


    /**
     * 修改密码
     */
    @PutMapping("/password")
    public Response editPassword(SysUserEditPasswordCmd cmd) {
        return sysUserEditPasswordCmdExe.execute(cmd);
    }

}
