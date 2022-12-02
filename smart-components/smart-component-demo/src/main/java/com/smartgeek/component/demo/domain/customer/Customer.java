package com.smartgeek.component.demo.domain.customer;


import com.alibaba.cola.domain.Entity;
import com.smartgeek.component.web.model.base.BasisEntity;
import lombok.Data;

@Entity
@Data
public class Customer extends BasisEntity {


    private Long customerId;

    private String name;


    public void init() {

    }

    public void valid() {


    }
}