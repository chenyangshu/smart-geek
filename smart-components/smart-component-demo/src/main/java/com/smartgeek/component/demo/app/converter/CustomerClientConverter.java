package com.smartgeek.component.demo.app.converter;

import com.smartgeek.component.demo.client.dto.CustomerAddCmd;
import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.mapping.BeanMappingI;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author cys
 * @date 2022/11/27 15:48
 * @description:
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CustomerClientConverter extends BeanMappingI<CustomerAddCmd, Customer> {
}
