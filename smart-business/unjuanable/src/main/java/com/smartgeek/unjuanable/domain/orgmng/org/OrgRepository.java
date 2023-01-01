package com.smartgeek.unjuanable.domain.orgmng.org;

import java.util.Optional;


public interface OrgRepository {
    Optional<Org> findByIdAndStatus(long tenantId, Long id
            , OrgStatus status);

    int countBySuperiorAndName(long tenantId, Long superiorId
            , String name);

    boolean existsBySuperiorAndName(Long tenant, Long superior
            , String name);

    Org save(Org org);

    Optional<Org>  findById(Long tenantId, Long id);

    void update(Org org);
}
