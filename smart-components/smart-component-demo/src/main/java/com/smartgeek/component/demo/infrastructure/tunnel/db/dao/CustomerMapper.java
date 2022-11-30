package com.smartgeek.component.demo.infrastructure.tunnel.db.dao;

import com.smartgeek.component.demo.infrastructure.tunnel.db.po.CustomerPO;
import com.smartgeek.component.web.mapper.BasicMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cys
 */
@Mapper
public interface CustomerMapper extends BasicMapper<CustomerPO> {
}
