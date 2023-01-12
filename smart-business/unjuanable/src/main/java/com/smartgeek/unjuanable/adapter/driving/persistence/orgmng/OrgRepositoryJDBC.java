package com.smartgeek.unjuanable.adapter.driving.persistence.orgmng;

import com.smartgeek.unjuanable.domain.orgmng.org.OrgRepository;
import com.smartgeek.unjuanable.domain.orgmng.org.Org;
import com.smartgeek.unjuanable.domain.orgmng.org.OrgStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class OrgRepositoryJDBC implements OrgRepository {

    @Override
    public Org save(Org org) {
        return null;

    }

    @Override
    public Optional<Org> findById(Long tenantId, Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Org org) {

    }

    @Override
    public Optional<Org> findByIdAndStatus(long tenantId, Long id, OrgStatus status) {
        return Optional.empty();
    }

    @Override
    public int countBySuperiorAndName(long tenantId, Long superiorId, String name) {
        return 0;
    }

    @Override
    public boolean existsBySuperiorAndName(Long tenant, Long superior, String name) {
        return false;
    }
}
