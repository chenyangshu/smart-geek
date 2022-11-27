package com.smartgeek.component.demo.client.dto.query;

import com.alibaba.cola.dto.Query;
import lombok.Data;

/**
 * @author cys
 * @date 2022/11/27 16:52
 * @description:
 */
@Data
public class CustomerListByNameQry extends Query {
    private String customerName;
    private String companyName;
}
