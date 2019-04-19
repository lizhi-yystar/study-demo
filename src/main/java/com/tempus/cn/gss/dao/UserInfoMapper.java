package com.tempus.cn.gss.dao;

import com.tempus.cn.gss.bean.CustomerInfoModel;
import com.tempus.cn.gss.bean.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
@author:Administrator
@date:2019/2/28
@description:
@version:1.0
**/
@Repository
public interface UserInfoMapper {
    UserInfo queryUserName(@Param("id")String id);

    CustomerInfoModel queryCustomerInfo(String customerNo);
}
