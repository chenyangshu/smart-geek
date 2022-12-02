package com.smartgeek.component.web.repository.impl.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.smartgeek.component.web.converter.BaseConverter;
import com.smartgeek.component.web.mapper.BaseMapper;
import com.smartgeek.component.web.mapper.SubBaseMapper;
import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubBaseEntity;
import com.smartgeek.component.web.repository.impl.BaseRepositoryAdapter;
import com.smartgeek.component.web.repository.impl.SubTreeRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * 数据封装层处理 操作方法 主子基类通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Entity
 * @param <P>   Po
 * @param <PM>  PoMapper
 * @param <SQ>  SubQuery
 * @param <SD>  SubEntity
 * @param <SP>  SubPo
 * @param <SPM> SubPoMapper
 * @author cys
 */
public abstract class SubBaseHandleRepositoryAdapter<Q extends P, D extends P, P extends SubBaseEntity<SD>, PM extends SubBaseMapper<Q, D, P, SQ, SD, SP>, CT extends BaseConverter<Q, D, P>, SQ extends SP, SD extends SP, SP extends BaseEntity, SPM extends BaseMapper<SQ, SD, SP>, SCT extends BaseConverter<SQ, SD, SP>> extends BaseRepositoryAdapter<Q, D, P, PM, CT> {

    @Autowired
    protected SPM subMapper;

    @Autowired
    protected SCT subConverter;

    /** SubEntity泛型的类型 */
    @SuppressWarnings("unchecked")
    private Class<SD> SDClass = (Class<SD>) getClazz(5);

    protected Class<SD> getSDClass() {
        return SDClass;
    }

    /**
     * 查询 设置主子表中子表外键值
     *
     * @param queryWrapper 条件构造器
     * @param d            数据对象
     * @see SubTreeRepositoryAdapter#selectByIdExtra(Serializable)
     */
    protected void querySetForeignKey(LambdaQueryWrapper<SP> queryWrapper, D d) {
        setForeignKey(queryWrapper, null, d, null);
    }

    /**
     * 查询 设置主子表中子表外键值
     *
     * @param queryWrapper 条件构造器
     * @param foreignKey   子表外键值
     * @see SubTreeRepositoryAdapter#checkExistSub(Serializable)
     * @see SubTreeRepositoryAdapter#checkExistNormalSub(Serializable)
     */
    protected void querySetForeignKey(LambdaQueryWrapper<SP> queryWrapper, Serializable foreignKey) {
        setForeignKey(queryWrapper, null, null, foreignKey);
    }

    /**
     * 插入/删除 设置主子表中子表外键值
     *
     * @param updateWrapper 条件构造器
     * @param d             数据对象
     * @see SubTreeRepositoryAdapter#updateSubStatus(Serializable, String)
     * @see SubTreeRepositoryAdapter#deleteSub(Serializable)
     */
    protected void updateSetForeignKey(LambdaUpdateWrapper<SP> updateWrapper, D d) {
        setForeignKey(null, updateWrapper, d, null);
    }

    /**
     * 插入/删除 设置主子表中子表外键值
     *
     * @param updateWrapper 条件构造器
     * @param foreignKey    子表外键值
     * @see SubTreeRepositoryAdapter#updateSubStatus(Serializable, String)
     * @see SubTreeRepositoryAdapter#deleteSub(Serializable)
     */
    protected void updateSetForeignKey(LambdaUpdateWrapper<SP> updateWrapper, Serializable foreignKey) {
        setForeignKey(null, updateWrapper, null, foreignKey);
    }

    /**
     * 插入/删除 设置主子表中子表外键值
     *
     * @param queryWrapper  条件构造器
     * @param updateWrapper 条件构造器
     * @param d             数据对象
     * @param foreignKey    子表外键值
     */
    protected abstract void setForeignKey(LambdaQueryWrapper<SP> queryWrapper, LambdaUpdateWrapper<SP> updateWrapper, D d, Serializable foreignKey);
}
