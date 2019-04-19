package com.tempus.cn.gss.dao;

import com.tempus.cn.gss.bean.PaymentInfoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentMapper {
   List<PaymentInfoModel> queryPaymentInfo(String saleOrderNo);
}
