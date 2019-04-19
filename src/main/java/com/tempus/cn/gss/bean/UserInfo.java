package com.tempus.cn.gss.bean;

import java.io.Serializable;

/**
 * @author:Administrator
 * @date:2019/3/1
 * @description:
 * @version:
 **/
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 7148348476113538544L;

    private Long userId;
    private String userName;
    private Integer departmentId;
    private String departmentName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getUserName() {
        return userName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
