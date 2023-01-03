package com.smartgeek.multisaas.app.orgmng.dept;

import com.alibaba.cola.dto.Command;
import lombok.Data;

import java.util.List;

/**
 * @author cys
 */
@Data
public class SysDeptBatchRemoveCmd extends Command {

    private List<Long> idList;

    public SysDeptBatchRemoveCmd(List<Long> idList) {
        this.idList = idList;
    }
}
