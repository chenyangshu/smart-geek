package com.smartgeek.component.web.appservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * web层 通用数据处理
 *
 * @author xueyi
 */
public class BasisAppService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

//    /**
//     * 将前台传递过来的日期格式的字符串，自动转化为Date类型
//     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        // LocalDateTime 类型转换
//        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
//            @Override
//            public void setAsText(String text) {
//                setValue(getLocalDateTime(text));
//            }
//        });
//    }

//    /**
//     * 设置请求分页数据
//     */
//    protected void startPage() {
//        PageUtils.startPage();
//    }
//
//    /**
//     * 清理分页的线程变量
//     */
//    protected void clearPage() {
//        PageUtils.clearPage();
//    }

//    /**
//     * 响应请求分页数据
//     */
//    @SuppressWarnings({"rawtypes", "unchecked"})
//    protected AjaxResult getDataTable(List<?> list) {
//        TableDataInfo rspData = new TableDataInfo();
//        rspData.setItems(list);
//        rspData.setTotal(new PageInfo(list).getTotal());
//        return AjaxResult.success(rspData);
//    }

//    /**
//     * 获取LocalDateTime
//     */
//    private LocalDateTime getLocalDateTime(String text) {
//        if (StrUtil.isNotEmpty(text) && text.length() <= 10)
//            return LocalDateTimeUtil.parse(text, DatePattern.NORM_DATE_PATTERN);
//        else
//            return LocalDateTimeUtil.parse(text, DatePattern.NORM_DATETIME_PATTERN);
//    }

//    /**
//     * 响应返回结果
//     *
//     * @param rows 影响行数
//     * @return 操作结果
//     */
//    protected AjaxResult toAjax(int rows) {
//        return rows > 0 ? AjaxResult.success() : AjaxResult.error();
//    }
//
//    /**
//     * 响应返回结果
//     *
//     * @param result 结果
//     * @return 操作结果
//     */
//    protected AjaxResult toAjax(boolean result) {
//        return result ? success() : error();
//    }
//
//    /**
//     * 返回成功
//     */
//    public AjaxResult success() {
//        return AjaxResult.success();
//    }
//
//    /**
//     * 返回失败消息
//     */
//    public AjaxResult error() {
//        return AjaxResult.error();
//    }
//
//    /**
//     * 返回成功消息
//     */
//    public AjaxResult success(String message) {
//        return AjaxResult.success(message);
//    }
//
//    /**
//     * 返回失败消息
//     */
//    public AjaxResult error(String message) {
//        return AjaxResult.error(message);
//    }
}