package com.tempus.cn.gss.bean;

import java.io.Serializable;

public class PaymentInfoModel implements Serializable {

    private static final long serialVersionUID = -4626839858648908846L;

    private String paymentMethod;

    private String paymentFlownNum;

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentFlownNum() {
        return paymentFlownNum;
    }

    public void setPaymentFlownNum(String paymentFlownNum) {
        this.paymentFlownNum = paymentFlownNum;
    }
}
