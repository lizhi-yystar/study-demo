package com.tempus.cn.gss.bean;

import java.io.Serializable;

/**
@author:Administrator
@date:2019/3/6
@description:客户信息
@version:1.0
**/
public class CustomerInfoModel implements Serializable {

    private static final long serialVersionUID = 9208112226603106390L;

    private String customerNo;

    private String customerName;

    private String orderSource;

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }
}
