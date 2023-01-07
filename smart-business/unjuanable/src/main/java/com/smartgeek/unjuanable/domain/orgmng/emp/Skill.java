package com.smartgeek.unjuanable.domain.orgmng.emp;
// imports ...

import com.smartgeek.unjuanable.common.framework.AuditableEntity;

import java.time.LocalDateTime;

public class Skill extends AuditableEntity {
    private Long id;            // 只读
    private Long tenantId;      // 只读
    private Long skillTypeId;   // 只读，表示到技能类型的ID关联
    SkillLevel level;           // 读写
    private int duration;       // 读写

    // 包级私有权限
    Skill(Long tenantId, Long skillTypeId, LocalDateTime createdAt, Long createdBy) {
        super(createdAt, createdBy);
        this.tenantId = tenantId;
        this.skillTypeId = skillTypeId;
    }

    public Long getId() {
        return id;
    }

    public Long getSkillTypeId() {
        return skillTypeId;
    }

    public SkillLevel getLevel() {
        return level;
    }

    // 包级私有权限
    void setLevel(SkillLevel level) {
        this.level = level;
    }

    public int getDuration() {
        return duration;
    }

    // 包级私有权限
    void setDuration(int duration) {
        this.duration = duration;
    }
}