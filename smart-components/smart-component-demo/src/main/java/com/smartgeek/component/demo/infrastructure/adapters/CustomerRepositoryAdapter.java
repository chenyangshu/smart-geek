package com.smartgeek.component.demo.infrastructure.adapters;

import com.smartgeek.component.annotation.infrastructure.Adapter;
import com.smartgeek.component.demo.domain.customer.Customer;
import com.smartgeek.component.demo.domain.customer.ports.ICustomerRepositoryPort;
import com.smartgeek.component.demo.infrastructure.converter.CustomerEntityConverter;
import com.smartgeek.component.demo.infrastructure.tunnel.db.dao.CustomerMapper;
import com.smartgeek.component.demo.infrastructure.tunnel.db.po.CustomerPO;
import com.smartgeek.component.web.repository.impl.RepositoryAdapter;

/**
 * @author cys
 */
@Adapter
public class CustomerRepositoryAdapter extends RepositoryAdapter<Customer, CustomerPO, CustomerEntityConverter, CustomerMapper> implements ICustomerRepositoryPort {
}
