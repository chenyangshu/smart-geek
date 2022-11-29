package com.smartgeek.component.web.domainservice.impl.handle;

import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 服务层 操作方法 基类实现通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Entity
 * @param <IDG> EntityIManager
 * @author xueyi
 */
public class BaseHandleServiceImpl<Q extends BaseEntity, D extends BaseEntity, IDG extends IBaseRepository<Q, D>> {

    @Autowired
    protected IDG baseManager;
}
