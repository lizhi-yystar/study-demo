package com.tempus.cn.gss.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
@author:Administrator
@date:2019/2/28
@description:
@version:乘客&价格信息
**/
public class PassengerInfoModel implements Serializable {
    
    private static final long serialVersionUID = 3518426245420840870L;
    private String passengerNo;
    //姓
    private String sureName;
    //名称
    private String name;
    //乘客姓名
    private String passengerName;
    //出票类型
    private String ticketType;
    //销售票价
    private BigDecimal saleTicketPrice;
    //销售税费
    private BigDecimal saleTax;
    //销售返点点数
    private BigDecimal saleRebate;
    //返利
    private BigDecimal saleRebateMoney;
    //销售应收价格
    private BigDecimal salePrice;
    //服务费
    private BigDecimal serviceFee;
    //毛利
    private BigDecimal profit;
    //部门毛利
    private BigDecimal departmentProfit;
    //采购票价
    private BigDecimal shoppingTicketPrice;
    //采购税费
    private BigDecimal shoppingTax;
    //采购返点
    private BigDecimal shoppingRebate;
    //采购返利
    private BigDecimal shoppingRebateMoney;
    //采购应收金额
    private BigDecimal shoppingPrice;
    //采购计奖价
    private BigDecimal shoppingAwardPrice;
    //销售计奖价
    private BigDecimal saleAwardPrice;
    //计算价
    private BigDecimal settleMentAmount;

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSaleTicketPrice() {
        return saleTicketPrice;
    }

    public void setSaleTicketPrice(BigDecimal saleTicketPrice) {
        this.saleTicketPrice = saleTicketPrice;
    }

    public BigDecimal getSaleTax() {
        return saleTax;
    }

    public void setSaleTax(BigDecimal saleTax) {
        this.saleTax = saleTax;
    }

    public BigDecimal getSaleRebate() {
        return saleRebate;
    }

    public void setSaleRebate(BigDecimal saleRebate) {
        this.saleRebate = saleRebate;
    }

    public BigDecimal getSaleRebateMoney() {
        if(this.saleRebate!=null && this.saleAwardPrice !=null){
            return  this.saleRebate.divide(new BigDecimal(100),2).multiply(this.saleAwardPrice);
        }else{
            return saleRebateMoney;
        }
    }

    public void setSaleRebateMoney(BigDecimal saleRebateMoney) {
        this.saleRebateMoney = saleRebateMoney;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getDepartmentProfit() {
        return departmentProfit;
    }

    public void setDepartmentProfit(BigDecimal departmentProfit) {
        this.departmentProfit = departmentProfit;
    }

    public BigDecimal getShoppingTicketPrice() {
        return shoppingTicketPrice;
    }

    public void setShoppingTicketPrice(BigDecimal shoppingTicketPrice) {
        this.shoppingTicketPrice = shoppingTicketPrice;
    }

    public BigDecimal getShoppingTax() {
        return shoppingTax;
    }

    public void setShoppingTax(BigDecimal shoppingTax) {
        this.shoppingTax = shoppingTax;
    }

    public BigDecimal getShoppingRebate() {
        return shoppingRebate;
    }

    public void setShoppingRebate(BigDecimal shoppingRebate) {
        this.shoppingRebate = shoppingRebate;
    }

    public BigDecimal getShoppingRebateMoney() {
        if(this.shoppingAwardPrice !=null && this.shoppingRebate !=null) {
            return this.shoppingAwardPrice.multiply(this.shoppingRebate.divide(new BigDecimal(100),2));
        }else{
            return shoppingAwardPrice;
        }
    }

    public void setShoppingRebateMoney(BigDecimal shoppingRebateMoney) {
        this.shoppingRebateMoney = shoppingRebateMoney;
    }

    public BigDecimal getShoppingPrice() {
        return shoppingPrice;
    }

    public void setShoppingPrice(BigDecimal shoppingPrice) {
        this.shoppingPrice = shoppingPrice;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public BigDecimal getShoppingAwardPrice() {
        return shoppingAwardPrice;
    }

    public void setShoppingAwardPrice(BigDecimal shoppingAwardPrice) {
        this.shoppingAwardPrice = shoppingAwardPrice;
    }

    public BigDecimal getSaleAwardPrice() {
        return saleAwardPrice;
    }

    public void setSaleAwardPrice(BigDecimal saleAwardPrice) {
        this.saleAwardPrice = saleAwardPrice;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getPassengerName() {
        return this.sureName+"/"+this.name;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public BigDecimal getSettleMentAmount() {
        return salePrice;
    }

    public void setSettleMentAmount(BigDecimal settleMentAmount) {
        this.settleMentAmount = settleMentAmount;
    }
}
