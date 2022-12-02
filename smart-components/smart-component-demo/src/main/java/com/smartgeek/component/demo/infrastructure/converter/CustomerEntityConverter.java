package com.smartgeek.component.demo.infrastructure.converter;

import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.demo.infrastructure.tunnel.db.po.CustomerPO;
import com.smartgeek.component.web.converter.BasicConverter;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author cys
 * @date 2022/11/27 20:00
 * @description:
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface CustomerEntityConverter extends BasicConverter<Customer, CustomerPO> {
}
