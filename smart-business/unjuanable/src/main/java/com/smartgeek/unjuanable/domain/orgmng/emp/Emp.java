package com.smartgeek.unjuanable.domain.orgmng.emp;



// imports ...

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

    public void becomeRegular() {
        status = EmpStatus.REGULAR;
    }

    public void terminate() {
        status = EmpStatus.TERMINATED;
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
        Skill newSkill = new Skill(tenantId, skillTypeId
                , LocalDateTime.now(), userId);
        newSkill.setLevel(level);
        newSkill.setDuration(duration);

        skills.add(newSkill);
    }


    // 对 skills、experiences 和 postCodes 的操作 ...
}
