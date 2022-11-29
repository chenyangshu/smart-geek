package com.smartgeek.component.web.repository.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.smartgeek.component.constants.BaseConstants;
import com.smartgeek.component.constants.SqlConstants;
import com.smartgeek.component.web.annotation.TenantIgnore;
import com.smartgeek.component.web.converter.BaseConverter;
import com.smartgeek.component.web.mapper.TreeMapper;
import com.smartgeek.component.web.model.base.TreeEntity;
import com.smartgeek.component.web.repository.ITreeRepository;
import com.smartgeek.component.web.repository.impl.handle.TreeHandleRepositoryAdapter;

import java.io.Serializable;
import java.util.List;

/**
 * 数据封装层处理 树型通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <P>  Po
 * @param <PM> PoMapper
 * @author xueyi
 */
public class TreeRepositoryAdapter<Q extends P, D extends P, P extends TreeEntity<D>, PM extends TreeMapper<Q, D, P>, CT extends BaseConverter<Q, D, P>> extends TreeHandleRepositoryAdapter<Q, D, P, PM, CT> implements ITreeRepository<Q, D> {

    /**
     * 根据Id查询本节点及其所有祖籍节点
     *
     * @param id Id
     * @return 本节点及其所有祖籍节点数据对象集合
     */
    @Override
    public List<D> selectAncestorsListById(Serializable id) {
        P d = baseMapper.selectById(id);
        if (ObjectUtil.isNull(d) || StrUtil.isBlank(d.getAncestors()))
            return null;
        List<P> poList = baseMapper.selectList(
                Wrappers.<P>query().lambda()
                        .eq(P::getId, id)
                        .or().in(P::getId, StrUtil.splitTrim(d.getAncestors(), ",")));
        return baseConverter.mapperEntity(poList);
    }

    /**
     * 根据Id查询本节点及其所有子节点
     *
     * @param id Id
     * @return 本节点及其所有子节点数据对象集合
     */
    @Override
    public List<D> selectChildListById(Serializable id) {
        List<P> poList = baseMapper.selectList(
                Wrappers.<P>query().lambda()
                        .eq(P::getId, id)
                        .or().apply(SqlConstants.ANCESTORS_FIND, id));
        return baseConverter.mapperEntity(poList);
    }

    /**
     * 根据Id修改其子节点的状态
     *
     * @param id     Id
     * @param status 状态
     * @return 结果
     */
    @Override
    public int updateChildrenStatus(Serializable id, String status) {
        return baseMapper.update(null,
                Wrappers.<P>update().lambda()
                        .set(P::getStatus, status)
                        .apply(SqlConstants.ANCESTORS_FIND, id));
    }

    /**
     * 根据Id修改其子节点的祖籍
     *
     * @param id           Id
     * @param newAncestors 新祖籍
     * @param oldAncestors 旧祖籍
     * @return 结果
     */
    @Override
    public int updateChildrenAncestors(Serializable id, String newAncestors, String oldAncestors) {
        return baseMapper.update(null,
                Wrappers.<P>update().lambda()
                        .setSql(StrUtil.format("{} = insert({},{},{},'{}')", SqlConstants.Entity.ANCESTORS.getCode(), SqlConstants.Entity.ANCESTORS.getCode(), 1, oldAncestors.length(), newAncestors))
                        .apply(SqlConstants.ANCESTORS_FIND, id));
    }

    /**
     * 根据Id修改其子节点的祖籍和状态
     *
     * @param id           Id
     * @param status       状态
     * @param newAncestors 新祖籍
     * @param oldAncestors 旧祖籍
     * @return 结果
     */
    @Override
    public int updateChildren(Serializable id, String status, String newAncestors, String oldAncestors) {
        return baseMapper.update(null,
                Wrappers.<P>update().lambda()
                        .set(P::getStatus, status)
                        .setSql(StrUtil.format("{} = insert({},{},{},{})", SqlConstants.Entity.ANCESTORS.getCode(), SqlConstants.Entity.ANCESTORS.getCode(), 1, oldAncestors.length(), newAncestors))
                        .apply(SqlConstants.ANCESTORS_FIND, id));
    }

    /**
     * 根据Id删除其子节点
     *
     * @param id Id
     * @return 结果
     */
    @Override
    public int deleteChildren(Serializable id) {
        return baseMapper.delete(
                Wrappers.<P>update().lambda()
                        .eq(P::getId, id)
                        .apply(SqlConstants.ANCESTORS_FIND, id));
    }

    /**
     * 校验是否为父级的子级
     *
     * @param id       Id
     * @param parentId 父级Id
     * @return 结果 | true/false 是/否
     */
    @Override
    public D checkIsChild(Serializable id, Serializable parentId) {
        P po = baseMapper.selectOne(
                Wrappers.<P>query().lambda()
                        .eq(P::getId, id)
                        .apply(SqlConstants.ANCESTORS_FIND, parentId)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperEntity(po);
    }

    /**
     * 校验是否存在子节点
     *
     * @param id Id
     * @return 结果 | true/false 有/无
     */
    @Override
    public D checkHasChild(Serializable id) {
        P po = baseMapper.selectOne(
                Wrappers.<P>query().lambda()
                        .apply(SqlConstants.ANCESTORS_FIND, id)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperEntity(po);
    }

    /**
     * 校验是否有启用(正常状态)的子节点
     *
     * @param id Id
     * @return 结果 | true/false 有/无
     */
    @Override
    public D checkHasNormalChild(Serializable id) {
        P po = baseMapper.selectOne(
                Wrappers.<P>query().lambda()
                        .eq(P::getStatus, BaseConstants.Status.NORMAL.getCode())
                        .apply(SqlConstants.ANCESTORS_FIND, id)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperEntity(po);
    }

    /**
     * 校验名称是否唯一
     *
     * @param id       Id
     * @param parentId 父级Id
     * @param name     名称
     * @return 数据对象
     */
    @Override
    @TenantIgnore(tenantLine = true)
    public D checkNameUnique(Serializable id, Serializable parentId, String name) {
        P po = baseMapper.selectOne(
                Wrappers.<P>query().lambda()
                        .ne(P::getId, id)
                        .eq(P::getParentId, parentId)
                        .eq(P::getName, name)
                        .last(SqlConstants.LIMIT_ONE));
        return baseConverter.mapperEntity(po);
    }
}
