package com.smartgeek.component.web.appservice;

import com.smartgeek.component.web.appservice.handle.SubBaseHandleAppService;
import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubBaseEntity;
import com.smartgeek.component.web.domainservice.IBaseDomainService;
import com.smartgeek.component.web.domainservice.ISubBaseDomainService;

/**
 * 操作层 主子基类通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Entity
 * @param <IDS> EntityService
 * @param <SQ>  SubQuery
 * @param <SD>  SubEntity
 * @param <ISS> SubService
 * @author xueyi
 */
public abstract class SubBaseAppService<Q extends SubBaseEntity<SD>, D extends SubBaseEntity<SD>, IDS extends ISubBaseDomainService<Q, D, SQ, SD>, SQ extends BaseEntity, SD extends BaseEntity, ISS extends IBaseDomainService<SQ, SD>> extends SubBaseHandleAppService<Q, D, IDS, SQ, SD, ISS> {

//    /**
//     * 主子型 修改
//     * 考虑归属数据状态
//     *
//     * @see #EHandleSubStatusValidated(SubBaseEntity) 主子树型 归属数据状态逻辑校验
//     */
//    @Override
//    public AjaxResult edit(@Validated({V_E.class}) @RequestBody D d) {
//        EHandleSubStatusValidated(d);
//        return super.edit(d);
//    }
//
//    /**
//     * 主子型 修改
//     * 考虑归属数据状态
//     *
//     * @see #ESHandleSubStatusValidated(SubBaseEntity)  主子树型 归属数据状态逻辑校验
//     */
//    public AjaxResult editStatus(@RequestBody D d) {
//        ESHandleSubStatusValidated(d);
//        return super.editStatus(d);
//    }
//
//    /**
//     * 主子型 批量删除
//     * 考虑归属数据存在与否&&子节点存在与否
//     *
//     * @see #RHandleEmptyValidated(List)   基类 空校验
//     * @see #RHandleSubValidated(List)  主子型 归属数据存在与否校验
//     */
//    @Override
//    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
//        RHandleEmptyValidated(idList);
//        RHandleValidated(BaseConstants.Operate.DELETE, idList);
//        RHandleEmptyValidated(idList);
//        RHandleSubValidated(idList);
//        return toAjax(baseService.deleteByIds(idList));
//    }
}
