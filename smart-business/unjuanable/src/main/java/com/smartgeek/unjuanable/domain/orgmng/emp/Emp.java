package com.smartgeek.unjuanable.domain.orgmng.emp;



// imports ...

import com.smartgeek.component.exception.BusinessException;
import com.smartgeek.unjuanable.common.framework.AuditableEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Emp extends AuditableEntity {
    private Long id;          // 只读
    private Long tenantId;    // 只读
    private Long orgId;        // 读写
    private String num;       // 读写，员工编号
    private String idNum;     // 读写，身份证号
    private Gender Gender;    // 读写
    private LocalDate dob;    // 读写
    private EmpStatus status; // 读写

    private List<Skill> skills;              // 读写
    private List<WorkExperience> experiences;// 读写
    private List<String> postCodes;          // 读写，岗位代码

    public Emp(Long tenantId, LocalDateTime createdAt, Long createdBy) {
        super(createdAt, createdBy);
        this.tenantId = tenantId;
    }

    // other getters and setters ...

    public EmpStatus getStatus() {
        return status;
    }



    public Optional<Skill> getSkill(Long skillTypeId) {
        return skills.stream()
                .filter(s -> s.getSkillTypeId() == skillTypeId)
                .findAny();
    }

    public List<Skill> getSkills() {
        return Collections.unmodifiableList(skills);
    }

    void addSkill(Long skillTypeId, SkillLevel level
            , int duration, Long userId) {
        // 调用业务规则: 同一技能不能录入两次
        skillTypeShouldNotDuplicated(skillTypeId);
        Skill newSkill = new Skill(tenantId, skillTypeId
                , LocalDateTime.now(), userId);
        newSkill.setLevel(level);
        newSkill.setDuration(duration);

        skills.add(newSkill);
    }

    private void skillTypeShouldNotDuplicated(Long newSkillTypeId) {
        if (skills.stream().anyMatch(
                s -> s.getSkillTypeId() == newSkillTypeId)) {
            throw new RuntimeException("同一技能不能录入两次！");
        }
    }

    //转正
    void becomeRegular() {
        // 调用业务规则: 试用期的员工才能被转正
        onlyProbationCanBecomeRegular();
        status = EmpStatus.REGULAR;
    }

    public void addExperience(LocalDate startDate, LocalDate endDate, String company, Long userId) {
        // 调用业务规则: 工作经验的时间段不能重叠
        durationShouldNotOverlap(startDate, endDate);

        WorkExperience newExperience = new WorkExperience(
                tenantId
                , startDate
                , endDate
                , LocalDateTime.now()
                , userId);
        newExperience.setCompany(company);

        experiences.add(newExperience);
    }

    private void durationShouldNotOverlap(LocalDate startDate
            , LocalDate endDate) {
        if (experiences.stream().anyMatch(
                e -> overlap(e, startDate, endDate))) {
            throw new RuntimeException("工作经验的时间段不能重叠!");
        }
    }

    private boolean overlap(WorkExperience experience
            , LocalDate otherStart, LocalDate otherEnd) {
        LocalDate thisStart = experience.getStartDate();
        LocalDate thisEnd = experience.getEndDate();

        return otherStart.isBefore(thisEnd)
                && otherEnd.isAfter(thisStart);
    }

    //终止
    void terminate() {
        // 调用业务规则: 已经终止的员工不能再次终止
        shouldNotTerminateAgain();
        status = EmpStatus.TERMINATED;
    }

    // 实现业务规则
    private void onlyProbationCanBecomeRegular() {
        if (status != EmpStatus.PROBATION) {
            throw new RuntimeException("试用期员工才能转正！");
        }
    }

    private void shouldNotTerminateAgain() {
        if (status == EmpStatus.TERMINATED) {
            throw new RuntimeException("已经终止的员工不能再次终止！");
        }
    }

    // 对 skills、experiences 和 postCodes 的操作 ...
}
