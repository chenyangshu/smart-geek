package com.smartgeek.unjuanable.app.orgmng.empservice;

import com.smartgeek.unjuanable.app.orgmng.empservice.EmpAssembler;
import com.smartgeek.unjuanable.domain.orgmng.emp.Emp;
import com.smartgeek.unjuanable.domain.orgmng.emp.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpService {
    private final EmpRepository empRepository;
    private final EmpAssembler assembler;

    @Autowired
    public EmpService(EmpRepository empRepository
            , EmpAssembler assembler) {
        this.empRepository = empRepository;
        this.assembler = assembler;
    }

    @Transactional
    public EmpResponse addEmp(CreateEmpRequest request, Long userId) {
        Emp emp = assembler.fromCreateRequest(request, userId);
        
        empRepository.save(emp);
        return assembler.toResponse(emp);
    }

}