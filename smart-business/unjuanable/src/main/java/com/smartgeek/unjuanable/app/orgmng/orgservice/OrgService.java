package com.smartgeek.unjuanable.app.orgmng.orgservice;

import cn.hutool.core.bean.BeanUtil;
import com.smartgeek.unjuanable.domain.orgmng.org.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrgService {
    private final OrgBuilderFactory orgBuilderFactory;
    private final OrgRepository orgRepository;

    private final OrgHandler orgHandler;

    public OrgDto addOrg(OrgDto request) {
        OrgBuilder builder = orgBuilderFactory.create();
        Org org = builder.tenantId(request.getTenantId())
                .orgTypeCode(request.getOrgTypeCode())
                .leaderId(request.getLeaderId())
                .superiorId(request.getSuperiorId())
                .name(request.getName())
                .createdBy(0l)
                .build();

        org = orgRepository.save(org);
        return buildOrgDto(org);
    }

    private static OrgDto buildOrgDto(Org org) {
        // 领域对象转换为DTO...
        return BeanUtil.copyProperties(org, OrgDto.class);
    }


    public OrgDto updateOrgBasic(Long id,OrgDto request,Long userId){
        Org org = orgRepository.findById(request.getTenantId(), id)
                .orElseThrow(() -> {
                    throw new RuntimeException("要修改的组织(id =" + id + ")不存在！");
                });
        orgHandler.updateBasic(org,request.getName(),request.getLeaderId(),userId);
        orgRepository.update(org);
        return buildOrgDto(org);
    }

    public Long cancelOrg(Long id, Long tenant, Long userId) {
        Org org = orgRepository.findById(tenant, id)
                .orElseThrow(() -> {
                    throw new RuntimeException("要取消的组织(id ="
                            + id + "  )不存在！");
                });

        orgHandler.cancel(org, userId);
        orgRepository.update(org);

        return org.getId();
    }
}


