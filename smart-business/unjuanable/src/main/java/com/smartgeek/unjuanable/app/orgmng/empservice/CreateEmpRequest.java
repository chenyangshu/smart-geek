package com.smartgeek.unjuanable.app.orgmng.empservice;

import com.smartgeek.unjuanable.domain.orgmng.emp.Gender;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateEmpRequest {
    private Long id;          // 只读
    private Long tenantId;    // 只读
    private Long orgId;        // 读写
    private String num;       // 读写，员工编号
    private String idNum;     // 读写，身份证号
    private com.smartgeek.unjuanable.domain.orgmng.emp.Gender Gender;    // 读写
    private LocalDate dob;    // 读写
}
