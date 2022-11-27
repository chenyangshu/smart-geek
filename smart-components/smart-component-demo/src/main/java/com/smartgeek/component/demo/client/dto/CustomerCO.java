package com.smartgeek.component.demo.client.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author cys
 * @date 2022/11/27 16:55
 * @description:
 */
@Data
public class CustomerCO {
    private String customerId;
    private String memberId;
    private String customerName;
    private String customerType;
    @NotEmpty
    private String companyName;
    @NotEmpty
    private String source;
}
