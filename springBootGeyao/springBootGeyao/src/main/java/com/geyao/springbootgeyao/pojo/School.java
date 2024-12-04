package com.geyao.springbootgeyao.pojo;

import io.swagger.annotations.ApiModelProperty;

public class School {
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }
    @ApiModelProperty(value = "学校名称")
    private String schoolName;
    @ApiModelProperty(value = "学校id")
    private Integer schoolId;
}
