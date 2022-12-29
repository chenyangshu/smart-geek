package com.smartgeek.business.app.orgmng;

import cn.hutool.core.bean.BeanUtil;
import com.smartgeek.business.domain.orgmng.org.Org;
import com.smartgeek.business.domain.orgmng.org.OrgBuilder;
import com.smartgeek.business.domain.orgmng.org.OrgBuilderFactory;
import com.smartgeek.business.domain.orgmng.org.OrgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrgService {
    private final OrgBuilderFactory orgBuilderFactory;
    private final OrgRepository orgRepository;


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
}


