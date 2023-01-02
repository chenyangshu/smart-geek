package com.smartgeek.multisaas.adapter.driven.organize.web;

import com.alibaba.cola.dto.Response;
import com.smartgeek.multisaas.app.organize.SysDeptInnerAddCmd;
import com.smartgeek.multisaas.app.organize.SysDeptInnerAddCmdExe;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    private SysDeptInnerAddCmdExe sysDeptInnerAddCmdExe;

    @PostMapping("/inner/add")
    public Response addInner(@RequestBody SysDeptInnerAddCmd cmd) {
        return sysDeptInnerAddCmdExe.execute(cmd);
    }



}
