package com.tempus.cn.gss.dao;

import com.tempus.cn.gss.bean.BaseInfoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
@author:Administrator
@date:2019/2/28
@description:
@version:1.0
**/
@Repository
public interface BaseInfoMapper {
    List<BaseInfoModel> pageQuery();

    void updateSynchronizeStatus(String saleOrderNo);
}
