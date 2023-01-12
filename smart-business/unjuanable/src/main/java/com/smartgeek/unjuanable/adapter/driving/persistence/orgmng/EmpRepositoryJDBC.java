package com.smartgeek.unjuanable.adapter.driving.persistence.orgmng;

import com.smartgeek.unjuanable.domain.orgmng.emp.Emp;
import com.smartgeek.unjuanable.domain.orgmng.emp.EmpRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepositoryJDBC implements EmpRepository {

    @Override
    public void save(Emp emp) {

    }
}
