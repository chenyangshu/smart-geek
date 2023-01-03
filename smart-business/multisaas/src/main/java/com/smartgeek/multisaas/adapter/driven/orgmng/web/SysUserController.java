package com.smartgeek.multisaas.adapter.driven.orgmng.web;

import com.alibaba.cola.dto.Response;
import com.smartgeek.multisaas.app.orgmng.user.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cys
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Resource
    private SysUserAddCmdExe sysUserAddCmdExe;

    @Resource
    private SysUserEditCmdExe sysUserEditCmdExe;

    @Resource
    private SysUserBatchRemoveCmdExe sysUserBatchRemoveCmdExe;

    @Resource
    private SysUserEditRoleCmdExe sysUserEditRoleCmdExe;

    @Resource
    private SysUserResetPasswordCmdExe sysUserResetPasswordCmdExe;

    @PostMapping
    public Response add(@RequestBody SysUserAddCmd cmd) {
        return sysUserAddCmdExe.execute(cmd);
    }

    @PutMapping
    public Response edit(@RequestBody SysUserEditCmd cmd) {
        return sysUserEditCmdExe.execute(cmd);
    }

    @DeleteMapping("/batch/{idList}")
    public Response batchRemove(@PathVariable List<Long> idList) {
        return sysUserBatchRemoveCmdExe.execute(new SysUserBatchRemoveCmd(idList));
    }

    @PutMapping(value = "/auth")
    public Response editRoleAuth(@RequestBody SysUserEditRoleCmd cmd) {
        return sysUserEditRoleCmdExe.execute(cmd);
    }


    @PutMapping("/resetPwd")
    public Response resetPassword(@RequestBody SysUserResetPasswordCmd cmd) {
        return sysUserResetPasswordCmdExe.execute(cmd);
    }




}
