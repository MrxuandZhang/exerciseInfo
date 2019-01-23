package com.xmxy.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName BaseDao
 * @Author Administrator
 * @Date 2019/1/22 0022 14:16
 **/
public interface BaseDao<T> {
    void add(T t);//添加
    void update(T t);//修改
    void del(java.io.Serializable sid);//删除
    T get(java.io.Serializable sid);//获取
    int getTotal(@Param("t")T t);//获取总条数
    List<T> queryLimit(@Param("t")T t, @Param("start") Integer currentPage, @Param("pageNum")Integer pageNum);//查询
}
