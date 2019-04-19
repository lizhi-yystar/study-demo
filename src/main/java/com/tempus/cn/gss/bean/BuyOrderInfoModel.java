package com.tempus.cn.gss.bean;

import java.io.Serializable;

/**
@author:Administrator
@date:2019/3/6
@description:采购数据信息
@version:1.0
**/
public class BuyOrderInfoModel implements Serializable {
    private static final long serialVersionUID = 2263827376778535567L;

    private String buyOrderNo;

    private String buyLocker;

    private String channel;

    public String getBuyOrderNo() {
        return buyOrderNo;
    }

    public void setBuyOrderNo(String buyOrderNo) {
        this.buyOrderNo = buyOrderNo;
    }

    public String getBuyLocker() {
        return buyLocker;
    }

    public void setBuyLocker(String buyLocker) {
        this.buyLocker = buyLocker;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
