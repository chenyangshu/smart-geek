package com.smartgeek.multisaas.adapter.driven.orgmng.web;

import com.alibaba.cola.dto.MultiResponse;
import com.smartgeek.multisaas.app.orgmng.org.OrganizeScopeQryExe;
import com.smartgeek.multisaas.app.orgmng.org.OrganizeTreeExDeptNodeQryExe;
import com.smartgeek.multisaas.app.orgmng.org.SysOrganizeTreeCo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 组织控制器
 *
 * @author chenyangshu
 * @date 2023/01/02
 */
@RestController
@RequestMapping("/organize")
public class SysOrganizeController {

    @Resource
    private OrganizeScopeQryExe organizeScopeQryExe;

    @Resource
    private OrganizeTreeExDeptNodeQryExe organizeTreeExDeptNodeQryExe;

    /**
     * 获取组织范围
     *
     * @return {@link MultiResponse}<{@link SysOrganizeTreeCo}>
     */
    @GetMapping(value = "/organizeScope")
    public MultiResponse<SysOrganizeTreeCo> getOrganizeScope() {
        return organizeScopeQryExe.execute();
    }


    /**
     * 获取下拉树列表
     */
    @GetMapping("/option")
    public  MultiResponse<SysOrganizeTreeCo>  option() {
        return organizeTreeExDeptNodeQryExe.execute();
    }




}
