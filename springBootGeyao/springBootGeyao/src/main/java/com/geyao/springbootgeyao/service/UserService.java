package com.geyao.springbootgeyao.service;
import com.geyao.springbootgeyao.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {
   void addUser(User user);

   void deleteUser(Integer userId);

   void updateUser(User user);

   // 新增分页查询方法
   PageInfo<User> getAllUser(int pageNum, int pageSize);

   User findUserById(Integer userId);

   List<User> findAllUser();
}
