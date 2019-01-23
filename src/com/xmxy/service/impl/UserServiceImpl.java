package com.xmxy.service.impl;

import com.xmxy.base.Page;
import com.xmxy.dao.UserDao;
import com.xmxy.entity.UserInfo;
import com.xmxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Author Administrator
 * @Date 2019/1/23 0023 9:26
 **/
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void add(UserInfo userInfo) {
        userDao.add(userInfo);
    }

    @Override
    public void update(UserInfo userInfo) {
        userDao.update(userInfo);
    }

    @Override
    public void del(Serializable sid) {
        userDao.del(sid);
    }

    @Override
    public UserInfo get(Serializable sid) {
        return userDao.get(sid);
    }

    @Override
    public Page<UserInfo> query(UserInfo userInfo, String currentPage, String pageNum) {
        int start=(Integer.parseInt(currentPage)-1)*Integer.parseInt(pageNum);
        Page<UserInfo> page=new Page<>(currentPage,pageNum,userDao.getTotal(userInfo),userDao.queryLimit(userInfo,start,Integer.parseInt(pageNum)));
        return page;
    }

    @Override
    public void updatePass(UserInfo userInfo) {
        userDao.updatePass(userInfo);
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        return userDao.login(userInfo);
    }

    @Override
    public List<UserInfo> query() {
        return userDao.query();
    }
}
