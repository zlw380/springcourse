package com.bjpowernode.service;

import com.bjpowernode.dao.UserDao;
import com.bjpowernode.domain.SysUser;

public interface UserService {

    void addUser(SysUser user);
    UserDao getDao();
}
