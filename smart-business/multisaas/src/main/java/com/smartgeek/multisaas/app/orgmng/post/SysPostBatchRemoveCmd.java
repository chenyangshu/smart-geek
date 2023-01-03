package com.smartgeek.multisaas.app.orgmng.post;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import java.util.List;

/**
 * @author cys
 */
@Data
public class SysPostBatchRemoveCmd extends Command {

    private List<Long> idList;

    public SysPostBatchRemoveCmd(List<Long> idList) {
        this.idList = idList;
    }
}
