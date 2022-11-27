package com.smartgeek.component.demo.domain.customer;

import com.alibaba.cola.domain.Entity;
import lombok.Data;

@Entity
@Data
public class Customer {


    private Long customerId;

    private String name;


    public void init() {


    }

    public void valid() {


    }
}