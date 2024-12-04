package com.geyao.springbootgeyao.dao;

import com.geyao.springbootgeyao.pojo.School;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class SchoolDao {
    @Resource
    JdbcTemplate jdbcTemplate;
    // 新增学校
    public void addSchool(School school){
        String sql = "insert into geyao_school(schoolName) values(?)";
        jdbcTemplate.update(sql,school.getSchoolName());
    }
    // 查询全部学校
    public List<School> findAllSchool(){
        String sql = "select * from geyao_school";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(School.class));
    }
    // 根据id删除学校
    public void deleteSchool(Integer schoolId){
        String sql = "delete from geyao_school where schoolId = ?";
        jdbcTemplate.update(sql,schoolId);
    }

    // 更新学校
    public void updateSchool(School school){
        String sql = "update geyao_school set schoolName = ? where schoolId = ?";
        jdbcTemplate.update(sql,school.getSchoolName(),school.getSchoolId());
    }
}
