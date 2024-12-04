package com.geyao.springbootgeyao.dao;

import com.geyao.springbootgeyao.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository //持久层依赖注入注解
public class UserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    // 新增用户
    public void saveUser(User user) {
        String sql = "insert into geyao_user(username,age,sex) values(?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(), user.getAge(), user.getSex());
    }
    // 删除用户
    public void deleteUser(Integer userId) {
        String sql = "delete from geyao_user where userId = ?";
        jdbcTemplate.update(sql, userId);
    }
    // 更新用户
    public void updateUser(User user) {
        String sql = "update geyao_user set username = ?,age = ?,sex = ? where userId = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getAge(), user.getSex(), user.getUserId());
    }
    // 查询所有用户分页
    public PageInfo<User> findUsersByPage(int pageNum, int pageSize) {
        // 设置分页参数
        PageHelper.startPage(pageNum, pageSize);

        // 执行查询
        String sql = "select * from geyao_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

        // 将查询结果封装到 PageInfo 中
        return new PageInfo<>(userList);
    }
    // 根据id查找用户
    public User findUserById(Integer userId) {
        String sql = "select * from geyao_user where userId = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), userId);
    }
    // 查询所有用户
    public List<User> findAllUser() {
        String sql = "select * from geyao_user";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }
}
