package com.smartgeek.component.searcher;

import com.ejlchina.searcher.SearchResult;

import java.util.List;

/**
 * @author cys
 * @date 2022/11/27 22:47
 * @description:
 */
public interface BeanSearchEngine {


    /**
     * 适合需要分页的查询
     * @param <T> bean 类型
     * @param beanClass 要检索的 bean 类型
     * @param query 检索参数
     * @return 总条数，Bean 数据列表
     * */
    <T,Q> SearchResult<T> search(Class<T> beanClass, Q query);

    /**
     * 适合需要分页的查询
     * @param <T> bean 类型
     * @param beanClass 要检索的 bean 类型
     * @param query 检索参数
     * @param summaryFields 统计字段
     * @return 总条数，Bean 数据列表
     * */
    <T,Q> SearchResult<T> search(Class<T> beanClass, Q query, String[] summaryFields);

    /**
     * @param <T> bean 类型
     * @param beanClass 要检索的 bean 类型
     * @param query 检索参数（包括排序分页参数）
     * @return 满足条件的第一个Bean
     * */
    <T,Q> T searchFirst(Class<T> beanClass, Q query);

    /**
     * 适合不需要分页的查询
     * @param <T> bean 类型
     * @param beanClass 要检索的 bean 类型
     * @param query 检索参数（包括排序分页参数）
     * @return Bean 数据列表
     * */
    <T,Q> List<T> searchList(Class<T> beanClass,Q query);

    /**
     * 检索满足条件的所有Bean，不支持偏移
     * @param <T> bean 类型
     * @param beanClass 要检索的 bean 类型
     * @param query 检索参数（包括排序分页参数）
     * @return Bean 数据列表
     * */
    <T,Q> List<T> searchAll(Class<T> beanClass, Q query);

}
