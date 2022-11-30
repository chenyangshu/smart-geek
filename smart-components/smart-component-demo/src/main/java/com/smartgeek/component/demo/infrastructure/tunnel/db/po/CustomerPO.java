package com.smartgeek.component.demo.infrastructure.tunnel.db.po;

import com.smartgeek.component.web.model.base.BaseEntity;
import lombok.Data;

/**
 * @author cys
 * @date 2022/11/27 17:05
 * @description:
 */
@Data
public class CustomerPO extends BaseEntity {
    private String customerId;
    private String memberId;
    private String globalId;
    private long registeredCapital;
    private String companyName;
}
