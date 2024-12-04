package com.geyao.springbootgeyao.service.impl;

import com.geyao.springbootgeyao.dao.UserDao;
import com.geyao.springbootgeyao.pojo.User;
import com.geyao.springbootgeyao.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Transactional
    public void addUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public PageInfo<User> getAllUser(int pageNum, int pageSize) {
        return userDao.findUsersByPage(pageNum, pageSize);
    }

    @Override
    public User findUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAllUser();
    }
}
