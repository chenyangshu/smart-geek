package com.smartgeek.component.demo.client.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.smartgeek.component.demo.client.dto.CustomerAddCmd;
import com.smartgeek.component.demo.client.dto.CustomerCO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author cys
 * @date 2022/11/27 19:52
 * @description:
 */

@RequestMapping("/api/customer")
public interface CustomerClient {

    @PostMapping("/add")
    SingleResponse<String> addCustomer(@RequestBody @Validated CustomerAddCmd customerAddCmd);

    @GetMapping(value = "/list")
    MultiResponse<CustomerCO> listCustomerByName(@RequestParam String name);
}
