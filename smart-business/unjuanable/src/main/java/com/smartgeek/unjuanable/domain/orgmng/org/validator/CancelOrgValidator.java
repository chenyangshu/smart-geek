package com.smartgeek.unjuanable.domain.orgmng.org.validator;

import com.smartgeek.unjuanable.domain.orgmng.org.Org;

public class CancelOrgValidator {
    public void cancelledOrgShouldNotHasEmp(Long tenantId, Long id) {

    }


    public void OnlyEffectiveOrgCanBeCancelled(Org org) {
        if(!org.isEffective()){
            throw new RuntimeException("该组织不是有效状态,不能撤销");
        }
    }
}
