package com.smartgeek.unjuanable.app.orgmng.orgservice;

import com.smartgeek.unjuanable.domain.orgmng.org.OrgStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class OrgDto {

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

}
