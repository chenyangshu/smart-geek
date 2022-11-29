package com.smartgeek.component.web.repository.impl.handle;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.Page;
import com.smartgeek.component.constants.BaseConstants;
import com.smartgeek.component.web.converter.BaseConverter;
import com.smartgeek.component.web.mapper.BaseMapper;
import com.smartgeek.component.web.model.base.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * 数据封装层处理 操作方法 基类通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <P>  Po
 * @param <PM> PoMapper
 * @author xueyi
 */

public class BaseHandleRepositoryAdapter<Q extends P, D extends P, P extends BaseEntity, PM extends BaseMapper<Q, D, P>, CT extends BaseConverter<Q, D, P>> {

    @Autowired
    protected PM baseMapper;

    @Autowired
    protected CT baseConverter;

    /** Entity泛型的类型 */
    @SuppressWarnings("unchecked")
    private final Class<D> DClass = (Class<D>) getClazz(1);

    /** Po泛型的类型 */
    @SuppressWarnings("unchecked")
    private final Class<P> PClass = (Class<P>) getClazz(2);

    public Class<D> getDClass() {
        return DClass;
    }

    public Class<P> getPClass() {
        return PClass;
    }

    /**
     * 获取class
     *
     * @return class
     */
    protected Type getClazz(int index) {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            return pType.getActualTypeArguments()[index];
        }
        return null;
    }

    /**
     * 类型转换 | 持久化对象 -> 数据传输对象
     *
     * @param po 持久化对象
     * @return entity
     */
    protected D mapperEntity(P po) {
        return baseConverter.mapperEntity(po);
    }

    /**
     * 类型转换 | 持久化对象集合 -> 数据传输对象集合
     *
     * @param poList 持久化对象集合
     * @return entityList
     */
    protected List<D> mapperEntity(Collection<P> poList) {
        if (poList instanceof Page) {
            Page<P> pagePoList = (Page<P>) poList;
            Page<D> pageEntityList = baseConverter.mapperPageEntity(poList);
            pageCopy(pagePoList, pageEntityList);
            return pageEntityList;
        }
        return baseConverter.mapperEntity(poList);
    }

    /**
     * 类型转换 | 数据传输对象 -> 持久化对象
     *
     * @param entity 数据传输对象
     * @return po
     */
    protected P mapperPo(D entity) {
        return baseConverter.mapperPo(entity);
    }

    /**
     * 类型转换 | 数据传输对象集合 -> 持久化对象集合
     *
     * @param entityList 数据传输对象集合
     * @return poList
     */
    protected List<P> mapperPo(Collection<D> entityList) {
        if (entityList instanceof Page) {
            Page<D> pageEntityList = (Page<D>) entityList;
            Page<P> pagePoList = baseConverter.mapperPagePo(entityList);
            pageCopy(pageEntityList, pagePoList);
            return pagePoList;
        }
        return baseConverter.mapperPo(entityList);
    }

    /**
     * 分页参数复制
     *
     * @param copyPage  复制分页对象
     * @param pastePage 粘贴分页对象
     */
    @SuppressWarnings("rawtypes")
    private void pageCopy(Page copyPage, Page pastePage) {
        pastePage.setPageNum(copyPage.getPageNum());
        pastePage.setPageSize(copyPage.getPageSize());
        pastePage.setStartRow(copyPage.getStartRow());
        pastePage.setEndRow(copyPage.getEndRow());
        pastePage.setTotal(copyPage.getTotal());
        pastePage.setPages(copyPage.getPages());
        pastePage.setCount(copyPage.isCount());
        pastePage.setReasonable(copyPage.getReasonable());
        pastePage.setPageSizeZero(copyPage.getPageSizeZero());
        pastePage.setCountColumn(copyPage.getCountColumn());
        pastePage.setOrderBy(copyPage.getOrderBy());
        pastePage.setOrderByOnly(copyPage.isOrderByOnly());
    }

    /**
     * 查询条件附加
     *
     * @param selectType   查询类型
     * @param queryWrapper 条件构造器
     * @param query        数据查询对象
     */
    protected void SelectListQuery(BaseConstants.SelectType selectType, LambdaQueryWrapper<P> queryWrapper, Q query) {
    }
}
