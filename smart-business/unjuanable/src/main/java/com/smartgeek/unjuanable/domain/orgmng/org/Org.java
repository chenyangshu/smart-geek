package com.smartgeek.unjuanable.domain.orgmng.org;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 组织
 *
 * @author chenyangshu
 * @date 2022/12/29
 */
@Getter
@Setter
public class Org {
    private Long id;
    private Long tenantId;
    private Long superiorId;
    private String orgTypeCode;

    private Long leaderId;
    private String name;
    private OrgStatus status;

    private LocalDateTime createdAt;

    private Long createdBy;

    private LocalDateTime lastUpdatedAt;

    private Long lastUpdatedBy;


    public Org() {

        status = OrgStatus.EFFECTIVE;

    }


}
