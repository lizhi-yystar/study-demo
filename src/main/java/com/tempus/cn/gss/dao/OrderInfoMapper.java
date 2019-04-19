package com.tempus.cn.gss.dao;

import com.tempus.cn.gss.bean.LegInfoModel;
import com.tempus.cn.gss.bean.OrderDetailInfoModel;
import com.tempus.cn.gss.bean.PassengerInfoModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
@author:Administrator
@date:2019/2/28
@description:
@version:1.0
**/
@Repository
public interface OrderInfoMapper {

    List<PassengerInfoModel> queryPassengerInfoBySaleOrderNo(String saleOrderNo);

    List<LegInfoModel> queryLegInfoBySaleOrderNo(String saleOrderNo);

    List<OrderDetailInfoModel> queryLegTicketNoByLegs(Map map);

    List<OrderDetailInfoModel> queryTicketLegDetails(String saleOrderNo);
}
