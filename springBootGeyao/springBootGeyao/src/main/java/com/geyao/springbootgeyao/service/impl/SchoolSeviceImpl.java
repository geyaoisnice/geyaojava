package com.geyao.springbootgeyao.service.impl;

import com.geyao.springbootgeyao.dao.SchoolDao;
import com.geyao.springbootgeyao.pojo.School;
import com.geyao.springbootgeyao.service.SchoolService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

@Service
public class SchoolSeviceImpl implements SchoolService {
    @Resource
    private SchoolDao schoolDao;
    @Transactional
    public void addSchool(School school) {
schoolDao.addSchool(school);
    }

    @Override
    public List<School> findAllSchool() {
        return schoolDao.findAllSchool();
    }

    @Override
    public void deleteSchool(Integer schoolId) {
        schoolDao.deleteSchool(schoolId);
    }

    @Override
    public void updateSchool(School school) {
         schoolDao.updateSchool(school);
    }
}
