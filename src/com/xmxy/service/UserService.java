package com.xmxy.service;

import com.xmxy.base.BaseService;
import com.xmxy.entity.UserInfo;

import java.util.List;

/**
 * @ClassName UserService
 * @Author Administrator
 * @Date 2019/1/22 0022 17:02
 **/
public interface UserService extends BaseService<UserInfo> {
    void updatePass(UserInfo userInfo);//修改密码
    UserInfo login(UserInfo userInfo);//登录
    List<UserInfo> query();//查询全部
}
