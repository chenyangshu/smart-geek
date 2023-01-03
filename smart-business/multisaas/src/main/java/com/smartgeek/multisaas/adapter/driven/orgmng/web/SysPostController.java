package com.smartgeek.multisaas.adapter.driven.orgmng.web;

import com.alibaba.cola.dto.Response;
import com.smartgeek.multisaas.app.orgmng.post.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cys
 */
@RestController
@RequestMapping("/post")
public class SysPostController {

    @Resource
    private SysPostAddCmdExe sysPostAddCmdExe;

    @Resource
    private SysPostEditCmdExe sysPostEditCmdExe;

    @Resource
    private SysPostBatchRemoveCmdExe sysPostBatchRemoveCmdExe;

    @PostMapping
    public Response add(@RequestBody SysPostAddCmd cmd) {
        return sysPostAddCmdExe.execute(cmd);
    }

    @PutMapping
    public Response edit(@RequestBody SysPostEditCmd cmd) {
        return sysPostEditCmdExe.execute(cmd);
    }

    @DeleteMapping("/batch/{idList}")
    public Response batchRemove(@PathVariable List<Long> idList) {
        return sysPostBatchRemoveCmdExe.execute(new SysPostBatchRemoveCmd(idList));
    }


}
