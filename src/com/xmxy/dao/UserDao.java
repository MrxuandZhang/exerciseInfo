package com.xmxy.dao;

import com.xmxy.base.BaseDao;
import com.xmxy.entity.UserInfo;

import java.util.List;

/**
 * @ClassName UserDao
 * @Author Administrator
 * @Date 2019/1/23 0023 9:24
 **/
public interface UserDao extends BaseDao<UserInfo> {
     void updatePass(UserInfo userInfo);//修改密码
     UserInfo login(UserInfo userInfo);//登录
     List<UserInfo> query();//查询全部
}
