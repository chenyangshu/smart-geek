package com.smartgeek.component.web.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smartgeek.component.web.model.base.BasisEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;

/**
 * 数据层 基类通用数据处理
 *
 * @param <P> Po
 * @author cys
 */
public interface BasicMapper<P extends BasisEntity> extends BaseMapper<P> {

    /**
     * 自定义批量插入
     */
    int insertBatch(@Param("collection") Collection<P> list);

    /**
     * 自定义批量更新，条件为主键
     */
    int updateBatch(@Param("collection") Collection<P> list);

}
