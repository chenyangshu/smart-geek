package com.smartgeek.component.web.domainservice.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.smartgeek.component.constants.BaseConstants;
import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.repository.IBaseRepositoryPort;
import com.smartgeek.component.web.domainservice.IBaseDomainService;
import com.smartgeek.component.web.domainservice.impl.handle.BaseHandleServiceImpl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * 服务层 基类实现通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Entity
 * @param <IDG> EntityIManager
 * @author cys
 */
public class BaseDomainServiceImpl<Q extends BaseEntity, D extends BaseEntity, IDG extends IBaseRepositoryPort<Q, D>> extends BaseHandleServiceImpl<Q, D, IDG> implements IBaseDomainService<Q, D> {

    /**
     * 查询数据对象列表
     *
     * @param query 数据查询对象
     * @return 数据对象集合
     */
    @Override
    public List<D> selectList(Q query) {
        return baseManager.selectList(query);
    }

    /**
     * 查询数据对象列表 | 附加数据
     *
     * @param query 数据查询对象
     * @return 数据对象集合
     */
    @Override
    public List<D> selectListExtra(Q query) {
        return baseManager.selectListExtra(query);
    }

    /**
     * 查询数据对象列表 | 数据权限 | 附加数据
     *
     * @param query 数据查询对象
     * @return 数据对象集合
     */
    @Override
    public List<D> selectListScope(Q query) {
        return baseManager.selectListExtra(query);
    }

    /**
     * 根据Id集合查询数据对象列表
     *
     * @param idList Id集合
     * @return 数据对象集合
     */
    @Override
    public List<D> selectListByIds(Collection<? extends Serializable> idList) {
        return baseManager.selectListByIds(idList);
    }

    /**
     * 根据Id查询单条数据对象
     *
     * @param id Id
     * @return 数据对象
     */
    @Override
    public D selectById(Serializable id) {
        return baseManager.selectById(id);
    }

    /**
     * 根据Id查询单条数据对象 | 附加数据
     *
     * @param id Id
     * @return 数据对象
     */
    @Override
    public D selectByIdExtra(Serializable id) {
        return baseManager.selectByIdExtra(id);
    }

    /**
     * 新增数据对象
     *
     * @param d 数据对象
     * @return 结果
     */
    @Override
    public int insert(D d) {
        return baseManager.insert(d);
    }

    /**
     * 新增数据对象（批量）
     *
     * @param entityList 数据对象集合
     */
    @Override
    public int insertBatch(Collection<D> entityList) {
        return baseManager.insertBatch(entityList);
    }

    /**
     * 修改数据对象
     *
     * @param d 数据对象
     * @return 结果
     */
    @Override
    public int update(D d) {
        return baseManager.update(d);
    }

    /**
     * 修改数据对象（批量）
     *
     * @param entityList 数据对象集合
     */
    @Override
    public int updateBatch(Collection<D> entityList) {
        return baseManager.updateBatch(entityList);
    }

    /**
     * 修改数据对象状态
     *
     * @param id     Id
     * @param status 状态
     * @return 结果
     */
    @Override
    public int updateStatus(Serializable id, String status) {
        return baseManager.updateStatus(id, status);
    }

    /**
     * 根据Id删除数据对象
     *
     * @param id Id
     * @return 结果
     */
    @Override
    public int deleteById(Serializable id) {
        return baseManager.deleteById(id);
    }

    /**
     * 根据Id集合删除数据对象
     *
     * @param idList Id集合
     * @return 结果
     */
    @Override
    public int deleteByIds(Collection<? extends Serializable> idList) {
        return baseManager.deleteByIds(idList);
    }

    /**
     * 校验名称是否唯一
     *
     * @param id   Id
     * @param name 名称
     * @return 结果 | true/false 唯一/不唯一
     */
    @Override
    public boolean checkNameUnique(Serializable id, String name) {
        return ObjectUtil.isNotNull(baseManager.checkNameUnique(ObjectUtil.isNull(id) ? BaseConstants.NONE_ID : id, name));
    }

    /**
     * 根据Id查询数据对象状态
     *
     * @param id Id
     * @return 结果 | NORMAL 正常 | DISABLE 停用 | EXCEPTION 异常（值不存在）
     */
    @Override
    public BaseConstants.Status checkStatus(Serializable id) {
        D info = ObjectUtil.isNotNull(id) ? baseManager.selectById(id) : null;
        return ObjectUtil.isNull(info)
                ? BaseConstants.Status.EXCEPTION
                : StrUtil.equals(BaseConstants.Status.NORMAL.getCode(), info.getStatus())
                ? BaseConstants.Status.NORMAL
                : BaseConstants.Status.DISABLE;
    }
}