package com.tempus.cn.gss.dao;

import com.tempus.cn.gss.bean.BuyOrderInfoModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyOrderInfoMapper {

    BuyOrderInfoModel qeuryBuyOrderInfo(String saleOrderNo);
}
