package com.smartgeek.unjuanable.common.framework;



import java.time.LocalDateTime;

public abstract class AuditableEntity {
    protected LocalDateTime createdAt;
    protected Long createdBy;
    protected LocalDateTime lastUpdatedAt;
    protected Long lastUpdatedBy;
    protected ChangingStatus changingStatus = ChangingStatus.NEW;

    public AuditableEntity(LocalDateTime createdAt, Long createdBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public ChangingStatus getChangingStatus() {
        return changingStatus;
    }

    public void toUpdate() {
        this.changingStatus = ChangingStatus.UPDATED;
    }

    public void toDelete() {
        this.changingStatus = ChangingStatus.DELETED;
    }

    public void toUnChang() {
        this.changingStatus = ChangingStatus.UNCHANGED;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }



}
