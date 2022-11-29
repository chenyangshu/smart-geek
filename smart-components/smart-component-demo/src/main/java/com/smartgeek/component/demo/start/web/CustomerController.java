package com.smartgeek.component.demo.start.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import com.smartgeek.component.demo.app.command.CustomerAddCmdExe;
import com.smartgeek.component.demo.client.api.CustomerClient;
import com.smartgeek.component.demo.app.command.query.CustomerListByNameQryExe;
import com.smartgeek.component.demo.client.dto.CustomerAddCmd;
import com.smartgeek.component.demo.client.dto.CustomerCO;
import com.smartgeek.component.demo.client.dto.query.CustomerListByNameQry;
import com.smartgeek.component.searcher.BeanSearchEngine;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cys
 * @date 2022/11/27 15:44
 * @description:
 */
@RestController
public class CustomerController implements CustomerClient {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;
    @Resource
    private CustomerListByNameQryExe customerListByNameQryExe;
    @Resource
    private BeanSearchEngine beanSearchEngine;

    public SingleResponse<String> addCustomer(CustomerAddCmd customerAddCmd) {
        return customerAddCmdExe.execute(customerAddCmd);
    }

    public MultiResponse<CustomerCO> listCustomerByName(String name) {
        CustomerListByNameQry customerListByNameQry = new CustomerListByNameQry();
        customerListByNameQry.setCustomerName(name);
        List<CustomerCO> customerCOS = beanSearchEngine.searchList(CustomerCO.class, customerListByNameQry);
        return MultiResponse.of(customerCOS);
//        return customerListByNameQryExe.execute(customerListByNameQry);
    }

}