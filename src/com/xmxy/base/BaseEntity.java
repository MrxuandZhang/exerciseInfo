package com.xmxy.base;

import java.io.Serializable;

/**
 * @ClassName BaseEntity
 * @Author Administrator
 * @Date 2019/1/22 0022 14:17
 * 实体基础父类
 **/
public class BaseEntity implements Serializable {

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public BaseEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public BaseEntity() {}
}
