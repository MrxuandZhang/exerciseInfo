package com.xmxy.base;

/**
 * @ClassName BaseService
 * @Author Administrator
 * @Date 2019/1/22 0022 14:16
 **/
public interface BaseService<T> {
    void add(T t);
    void update(T t);
    void del(java.io.Serializable sid);
    T get(java.io.Serializable sid);
    Page<T> query(T t,String currentPage,String pageNum);
}
