package com.smartgeek.unjuanable.domain.orgmng.org;

import com.smartgeek.unjuanable.domain.orgmng.org.validator.CancelOrgValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.CommonValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgLeaderValidator;
import com.smartgeek.unjuanable.domain.orgmng.org.validator.OrgNameValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;




@Component
@RequiredArgsConstructor
public class OrgHandler {
    private final CommonValidator commonValidator;
    private final OrgNameValidator nameValidator;
    private final OrgLeaderValidator leaderValidator;
    private final CancelOrgValidator cancelValidator;



    public void updateBasic(Org org, String newName
            , Long newLeader, Long userId) {
        updateName(org, newName);
        updateLeader(org, newLeader);
        updateAuditInfo(org, userId);
    }

    public void cancel(Org org, Long userId) {
        cancelValidator.cancelledOrgShouldNotHasEmp(org.getTenantId()
                , org.getId());
        cancelValidator.OnlyEffectiveOrgCanBeCancelled(org);
        org.cancel();
        updateAuditInfo(org, userId);
    }

    private void updateLeader(Org org, Long newLeader) {
        if (newLeader != null && !newLeader.equals(org.getLeaderId())) {
            leaderValidator.leaderShouldBeEffective(org.getTenantId()
                    , newLeader);
            org.setLeaderId(newLeader);
        }
    }

    private void updateName(Org org, String newName) {
        if (newName != null && !newName.equals(org.getName())) {
            nameValidator.orgNameShouldNotEmpty(newName);
            nameValidator.nameShouldNotDuplicatedInSameSuperior(
                    org.getTenantId(), org.getSuperiorId(), newName);
            org.setName(newName);
        }
    }

    private void updateAuditInfo(Org org, Long userId) {
        // 设置最后修改人和时间
    }
}
