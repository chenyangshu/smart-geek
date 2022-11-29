package com.smartgeek.component.web.appservice;

import com.smartgeek.component.web.appservice.handle.BaseHandleAppService;
import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.domainservice.IBaseDomainService;

/**
 * 操作层 基类通用数据处理
 *
 * @param <Q>   Query
 * @param <D>   Entity
 * @param <IDS> EntityService
 * @author xueyi
 */
public abstract class BaseAppService<Q extends BaseEntity, D extends BaseEntity, IDS extends IBaseDomainService<Q, D>> extends BaseHandleAppService<Q, D, IDS> {

//    /**
//     * 查询列表
//     */
//    public AjaxResult list(Q query) {
//        startPage();
//        List<D> list = baseService.selectListScope(query);
//        return getDataTable(list);
//    }

//    /**
//     * 导出
//     */
//    public void export(HttpServletResponse response, Q query) {
//        List<D> list = baseService.selectListScope(query);
//        ExcelUtil<D> util = new ExcelUtil<>(getDClass());
//        util.exportExcel(response, list, StrUtil.format("{}数据", getNodeName()));
//    }

//    /**
//     * 查询详细
//     */
//    public AjaxResult getInfo(@PathVariable Serializable id) {
//        return AjaxResult.success(baseService.selectById(id));
//    }

//    /**
//     * 查询详细 | 附加数据
//     */
//    public AjaxResult getInfoExtra(@PathVariable Serializable id) {
//        return AjaxResult.success(baseService.selectByIdExtra(id));
//    }

//    /**
//     * 新增
//     */
//    public AjaxResult add(@Validated({V_A.class}) @RequestBody D d) {
//        AEHandleValidated(BaseConstants.Operate.ADD, d);
//        return toAjax(baseService.insert(d));
//    }

//    /**
//     * 强制新增
//     */
//    public AjaxResult addForce(@Validated({V_A.class}) @RequestBody D d) {
//        AEHandleValidated(BaseConstants.Operate.ADD_FORCE, d);
//        return toAjax(baseService.insert(d));
//    }

//    /**
//     * 修改
//     */
//    public AjaxResult edit(@Validated({V_E.class}) @RequestBody D d) {
//        AEHandleValidated(BaseConstants.Operate.EDIT, d);
//        return toAjax(baseService.update(d));
//    }
//
//    /**
//     * 强制修改
//     */
//    public AjaxResult editForce(@Validated({V_E.class}) @RequestBody D d) {
//        AEHandleValidated(BaseConstants.Operate.EDIT_FORCE, d);
//        return toAjax(baseService.update(d));
//    }

//    /**
//     * 修改状态
//     */
//    public AjaxResult editStatus(@RequestBody D d) {
//        ESHandleValidated(BaseConstants.Operate.EDIT_STATUS, d);
//        return toAjax(baseService.updateStatus(d.getId(), d.getStatus()));
//    }

//    /**
//     * 强制修改状态
//     */
//    public AjaxResult editStatusForce(@RequestBody D d) {
//        ESHandleValidated(BaseConstants.Operate.EDIT_STATUS_FORCE, d);
//        return toAjax(baseService.updateStatus(d.getId(), d.getStatus()));
//    }

//    /**
//     * 批量删除
//     *
//     * @see #RHandleEmptyValidated (List)  基类 空校验
//     */
//    public AjaxResult batchRemove(@PathVariable List<Long> idList) {
//        RHandleEmptyValidated(idList);
//        RHandleValidated(BaseConstants.Operate.DELETE, idList);
//        return toAjax(baseService.deleteByIds(idList));
//    }
//
//    /**
//     * 强制批量删除
//     *
//     * @see #RHandleEmptyValidated (List)  基类 空校验
//     */
//    public AjaxResult batchRemoveForce(@PathVariable List<Long> idList) {
//        RHandleEmptyValidated(idList);
//        RHandleValidated(BaseConstants.Operate.DELETE_FORCE, idList);
//        return toAjax(baseService.deleteByIds(idList));
//    }
//
//    /**
//     * 获取选择框列表
//     */
//    public AjaxResult option() {
//        try {
//            Q query = getQClass().newInstance();
//            query.setStatus(BaseConstants.Status.NORMAL.getCode());
//            return list(query);
//        } catch (Exception ignored) {
//        }
//        return AjaxResult.error();
//    }
}
