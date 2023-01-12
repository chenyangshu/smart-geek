package com.smartgeek.unjuanable.domain.orgmng.emp;
// imports ...

import com.smartgeek.unjuanable.common.framework.AuditableEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WorkExperience extends AuditableEntity {
    private Long id;              // 只读
    private Long tenantId;        // 只读
    private LocalDate startDate;  // 只读
    private LocalDate endDate;    // 只读
    private String company;       // 读写

    // 包级私有权限
    WorkExperience(Long tenantId, LocalDate startDate, LocalDate endDate
            , LocalDateTime createdAt, Long createdBy) {

        super(createdAt, createdBy);
        this.tenantId = tenantId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    // setters and getters ...
   
    // 包级私有权限
    void setCompany(String company) {
        this.company = company;
    }


    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}