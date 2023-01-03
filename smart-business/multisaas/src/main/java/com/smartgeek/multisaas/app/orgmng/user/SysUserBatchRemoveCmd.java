package com.smartgeek.multisaas.app.orgmng.user;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import java.util.List;

/**
 * @author cys
 */
@Data
public class SysUserBatchRemoveCmd extends Command {

    private List<Long> idList;

    public SysUserBatchRemoveCmd(List<Long> idList) {
        this.idList = idList;
    }
}
