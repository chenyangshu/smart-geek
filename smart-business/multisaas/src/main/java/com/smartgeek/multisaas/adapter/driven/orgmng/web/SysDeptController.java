package com.smartgeek.multisaas.adapter.driven.orgmng.web;

import com.alibaba.cola.dto.Response;
import com.smartgeek.multisaas.app.orgmng.dept.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统部门控制器
 *
 * @author chenyangshu
 * @date 2023/01/02
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController {

    @Resource
    private SysDeptAddCmdExe sysDeptAddCmdExe;

    @Resource
    private SysDeptEditCmdExe sysDeptEditCmdExe;

    @Resource
    private SysDeptBatchRemoveCmdExe sysDeptBatchRemoveCmdExe;

    @PostMapping
    public Response add(@RequestBody SysDeptAddCmd cmd) {
        return sysDeptAddCmdExe.execute(cmd);
    }

    @PutMapping
    public Response edit(@RequestBody SysDeptEditCmd cmd) {
        return sysDeptEditCmdExe.execute(cmd);
    }

    @DeleteMapping("/batch/{idList}")
    public Response batchRemove(@PathVariable List<Long> idList) {
        return sysDeptBatchRemoveCmdExe.execute(new SysDeptBatchRemoveCmd(idList));
    }


}
