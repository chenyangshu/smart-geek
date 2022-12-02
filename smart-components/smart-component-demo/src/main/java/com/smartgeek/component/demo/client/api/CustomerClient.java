package com.smartgeek.component.demo.client.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.smartgeek.component.demo.client.dto.CustomerAddCmd;
import com.smartgeek.component.demo.client.dto.clientobject.CustomerCO;
import com.smartgeek.component.demo.client.dto.query.CustomerListByNameQry;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author cys
 * @date 2022/11/27 19:52
 * @description:
 */
public interface CustomerClient {

    @PostMapping("/api/customer/add")
    SingleResponse<String> addCustomer(@RequestBody @Validated CustomerAddCmd customerAddCmd);

    @GetMapping(value = "/api/customer/list")
    MultiResponse<CustomerCO> listCustomerByName(@Validated CustomerListByNameQry customerListByNameQry);
}
