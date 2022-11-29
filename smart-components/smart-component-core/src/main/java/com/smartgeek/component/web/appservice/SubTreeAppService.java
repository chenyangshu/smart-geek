package com.smartgeek.component.web.appservice;

import com.smartgeek.component.web.appservice.handle.SubTreeHandleAppService;
import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubTreeEntity;
import com.smartgeek.component.web.domainservice.IBaseDomainService;
import com.smartgeek.component.web.domainservice.ISubTreeDomainService;

/**
 * 操作层 主子树型通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Entity
 * @param <IDS> EntityService
 * @param <SQ>  SubQuery
 * @param <SD>  SubEntity
 * @param <ISS> SubService
 * @author xueyi
 */
public abstract class SubTreeAppService<Q extends SubTreeEntity<D, SD>, D extends SubTreeEntity<D, SD>, IDS extends ISubTreeDomainService<Q, D, SQ, SD>, SQ extends BaseEntity, SD extends BaseEntity, ISS extends IBaseDomainService<SQ, SD>> extends SubTreeHandleAppService<Q, D, IDS, SQ, SD, ISS> {
//
//    /**
//     * 主子树型 修改
//     * 考虑归属数据状态&&子节点状态
//     *
//     * @see #EHandleSubStatusValidated(SubTreeEntity) 主子树型 归属数据状态逻辑校验
//     */
//    @Override
//    public AjaxResult edit(@Validated({V_E.class}) @RequestBody D d) {
//        EHandleSubStatusValidated(d);
//        return super.edit(d);
//    }
//
//    /**
//     * 主子树型 修改
//     * 考虑归属数据状态&&子节点状态
//     *
//     * @see #ESHandleSubStatusValidated(SubTreeEntity)  主子树型 归属数据状态逻辑校验
//     */
//    public AjaxResult editStatus(@RequestBody D d) {
//        ESHandleSubStatusValidated(d);
//        return super.editStatus(d);
//    }
//
//    /**
//     * 主子树型 批量删除
//     * 考虑归属数据存在与否&&子节点存在与否
//     *
//     * @see #RHandleEmptyValidated(List)   基类 空校验
//     * @see #RHandleTreeSubValidated(List)  主子树型 子节点存在与否校验&&归属数据存在与否校验
//     */
//    @Override
//    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
//        RHandleEmptyValidated(idList);
//        RHandleValidated(BaseConstants.Operate.DELETE, idList);
//        RHandleEmptyValidated(idList);
//        RHandleTreeSubValidated(idList);
//        return toAjax(baseService.deleteByIds(idList));
//    }
}
