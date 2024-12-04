package com.geyao.springbootgeyao.service;

import com.geyao.springbootgeyao.pojo.School;

import java.util.List;

public interface SchoolService {
    void addSchool(School school);

    List<School> findAllSchool();

    void deleteSchool(Integer schoolId);

    void updateSchool(School school);
}
