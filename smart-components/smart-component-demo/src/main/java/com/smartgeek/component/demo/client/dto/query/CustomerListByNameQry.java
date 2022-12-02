package com.smartgeek.component.demo.client.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author cys
 * @date 2022/11/27 16:52
 * @description:
 */
@Data
public class CustomerListByNameQry extends Query {
    @NotBlank
    private String customerName;
    @NotBlank
    private String companyName;
}
