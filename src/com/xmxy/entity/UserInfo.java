package com.xmxy.entity;

import com.xmxy.base.BaseEntity;

/**
 * @ClassName UserInfo
 * @Author Administrator
 * @Date 2019/1/23 0023 9:03
 **/
public class UserInfo extends BaseEntity {
    private String userName;
    private String userPassword;
    private String regCode;

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
