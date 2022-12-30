package com.smartgeek.unjuanable.domain.orgmng.org;


// import...

import com.smartgeek.unjuanable.domain.orgmng.org.validator.CommonValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.SuperiorValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgLeaderValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgNameValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgTypeValidator;

import java.time.LocalDateTime;

/**
 * 组织构建器
 *
 * @author chenyangshu
 * @date 2022/12/29
 */
public class OrgBuilder {
    //用到的 validator
    private final CommonValidator commonValidator;
    private final OrgTypeValidator orgTypeValidator;
    private final SuperiorValidator superiorValidator;
    private final OrgNameValidator orgNameValidator;
    private final OrgLeaderValidator orgLeaderValidator;

    //用这些属性保存创建对象用到的参数
    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;
    private Long leaderId;
    private String name;
    private Long createdBy;

    public OrgBuilder(CommonValidator commonValidator,
                      OrgTypeValidator orgTypeValidator,
                      SuperiorValidator superiorValidator,
                      OrgNameValidator orgNameValidator,
                      OrgLeaderValidator orgLeaderValidator) {
        this.commonValidator = commonValidator;
        this.orgTypeValidator = orgTypeValidator;
        this.superiorValidator = superiorValidator;
        this.orgNameValidator = orgNameValidator;
        this.orgLeaderValidator = orgLeaderValidator;
    }

    // 为builder 的 tenant 属性赋值，然后返回自己，以便实现链式调用
    public OrgBuilder tenantId(Long tenantId) {
        this.tenantId = tenantId;
        return this;
    }



    public OrgBuilder superiorId(Long superiorId) {
        this.superiorId = superiorId;
        return this;
    }

    public OrgBuilder orgTypeCode(String orgTypeCode) {
        this.orgTypeCode = orgTypeCode;
        return this;
    }


    public OrgBuilder leaderId(Long leaderId) {
        this.leaderId = leaderId;
        return this;
    }

    public OrgBuilder name(String name) {
        this.name = name;
        return this;
    }

    public OrgBuilder createdBy(Long createdBy) {
        this.createdBy = createdBy;
        return this;
    }


    // 其他5个属性赋值与 tenantId 类似 ...

    public Org build() {
        validate();
        Org org = new Org();
        org.setOrgTypeCode(this.orgTypeCode);
        org.setLeaderId(this.leaderId);
        org.setName(this.name);
        org.setSuperiorId(this.superiorId);
        org.setTenantId(this.tenantId);
        org.setCreatedBy(this.createdBy);
        org.setCreatedAt(LocalDateTime.now());
        return org;
    }

    private void validate() {
        commonValidator.tenantShouldValid(tenantId);
        orgTypeValidator.verify(tenantId, orgTypeCode);
        superiorValidator.verify(tenantId, superiorId, orgTypeCode);
        orgLeaderValidator.verify(tenantId, leaderId);
        orgNameValidator.verify(tenantId, name, superiorId);
    }
}
