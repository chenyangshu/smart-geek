package com.smartgeek.multisaas.app.orgmng.user;

import lombok.Data;

/**
 * @author cys
 */
@Data
public class SysUserEditPasswordCmd {
    private String oldPassword;

    private String newPassword;

    public SysUserEditPasswordCmd(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
