package com.tempus.cn.gss.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
@author:Administrator
@date:2019/3/6
@description:
@version:基础数据  batch发起的起始
**/
public class BaseInfoModel implements Serializable {

   private static final long serialVersionUID = -8957534624740839434L;

   //
   private Long id;
   //销售单号
   private String saleOrderNo;
   //销售员ID
   private Long locker;
   //出票员ID
   private Long buyLocker;
   //出票时间
   private Date issueTime;
   //销售币种
   private String saleCurrency;
   //汇率
   private BigDecimal exchangeRate;
   //客户编号
   private String customerNo;
   //所属公司
   private String company;

   @Override
   public String toString() {
      return "BaseInfoModel{" +
              "id=" + id +
              ", saleOrderNo='" + saleOrderNo + '\'' +
              ", locker=" + locker +
              ", buyLocker=" + buyLocker +
              ", issueTime=" + issueTime +
              ", saleCurrency='" + saleCurrency + '\'' +
              ", exchangeRate=" + exchangeRate +
              ", customerNo='" + customerNo + '\'' +
              ", company='" + company + '\'' +
              '}';
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getSaleOrderNo() {
      return saleOrderNo;
   }

   public void setSaleOrderNo(String saleOrderNo) {
      this.saleOrderNo = saleOrderNo;
   }

   public Long getLocker() {
      return locker;
   }

   public void setLocker(Long locker) {
      this.locker = locker;
   }

   public Long getBuyLocker() {
      return buyLocker;
   }

   public void setBuyLocker(Long buyLocker) {
      this.buyLocker = buyLocker;
   }

   public Date getIssueTime() {
      return issueTime;
   }

   public void setIssueTime(Date issueTime) {
      this.issueTime = issueTime;
   }

   public String getSaleCurrency() {
      return saleCurrency;
   }

   public void setSaleCurrency(String saleCurrency) {
      this.saleCurrency = saleCurrency;
   }

   public BigDecimal getExchangeRate() {
      return exchangeRate;
   }

   public void setExchangeRate(BigDecimal exchangeRate) {
      this.exchangeRate = exchangeRate;
   }

   public String getCustomerNo() {
      return customerNo;
   }

   public void setCustomerNo(String customerNo) {
      this.customerNo = customerNo;
   }

   public String getCompany() {
      return company;
   }

   public void setCompany(String company) {
      this.company = company;
   }
}
