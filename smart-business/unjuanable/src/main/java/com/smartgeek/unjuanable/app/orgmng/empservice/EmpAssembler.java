package com.smartgeek.unjuanable.app.orgmng.empservice;

import com.smartgeek.unjuanable.domain.orgmng.emp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpAssembler {
    EmpHandler handler; // Emp的领域服务
    OrgValidator orgValidator;

    @Autowired
    public EmpAssembler(EmpHandler handler, OrgValidator orgValidator) {
        this.handler = handler;
        this.orgValidator = orgValidator;
    }

    // 由 DTO 生成领域对象
    Emp fromCreateRequest(CreateEmpRequest request, Long userId) {
        //校验参数
        validateCreateRequest(request);
        
        // 生成员工号
        String empNum = handler.generateNum();

        Emp result = new Emp(null,null,null);
//        result.setNum(empNum)
//                .setIdNum(request.getIdNum())
//                .setDob(request.getDob())
//                .setOrgId(request.getOrgId())
//                .setGender(Gender.ofCode(request.getGenderCode()));
//
//        request.getSkills().forEach(s -> result.addSkill(
//                s.getSkillTypeId()
//                , SkillLevel.ofCode(s.getLevelCode())
//                , s.getDuration()
//                , userId));
//
//        request.getExperiences().forEach(e -> result.addExperience(
//                e.getStartDate()
//                , e.getEndDate()
//                , e.getCompany()
//                , userId));

        return result;
    }

    void validateCreateRequest(CreateEmpRequest request) {
        //业务规则：组织应该有效
        orgValidator.orgShouldValid(
                request.getTenantId(), request.getOrgId());
    }

    // 将领域对象转换成 DTO
    EmpResponse toResponse(Emp emp) {
      // ...
        return null;
    } 
}