package com.tempus.cn.gss.bean.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

/**
@author:Administrator
@date:2019/2/27
@description:出票报表导出模型类
@version:1.0
**/
public class ExportInfoModel implements Serializable {


    private static final long serialVersionUID = -4086308433333583257L;
    //主键
    private BigInteger id;
    //销售部门
    private String saleDepartment;
    //客户名称
    private String customerNameCn;
    //客户编号
    private String customerNo;
    //承运人
    private String carrier;
    //票号
    private String ticketNo;
    //行程
    private String trip;
    //航班号
    private String airNo;
    //舱位
    private String seat;
    //出票时间
    private Date issuedTime;
    //起飞时间
    private Date takeOffTime;
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
    //乘客姓名
    private String passengerName;
    //pnr编码
    private String pnr;
    //客票状态
    private String ticketStatus;
    //预订人
    private String booker;
    //预订人Id
    private Long bookerId;
    //出票员ID
    private Long ticketDrawerId;
    //出票员
    private String ticketDrawer;
    //出票渠道
    private String channel;
    //销售单号
    private String saleOrderNo;
    //支付类型
    private String paymentMethod;
    //支付流水号
    private String paymentFlownNum;
    //行程单号
    private String tripNo;
    //结算金额
    private BigDecimal settleMentAmount;
    //汇率
    private BigDecimal exchangeRate;
    //币种
    private String currency;
    //所属公司
    private String company;
    //预定渠道
    private String orderSource;
    //部门ID
    private Integer departmentId;

    private Date createSynTime;


    @Override
    public String toString() {
        return "ExportInfoModel{" +
                "id=" + id +
                ", saleDepartment='" + saleDepartment + '\'' +
                ", customerNameCn='" + customerNameCn + '\'' +
                ", customerNo='" + customerNo + '\'' +
                ", carrier='" + carrier + '\'' +
                ", ticketNo='" + ticketNo + '\'' +
                ", trip='" + trip + '\'' +
                ", airNo='" + airNo + '\'' +
                ", seat='" + seat + '\'' +
                ", issuedTime=" + issuedTime +
                ", takeOffTime=" + takeOffTime +
                ", saleTicketPrice=" + saleTicketPrice +
                ", saleTax=" + saleTax +
                ", saleRebate=" + saleRebate +
                ", saleRebateMoney=" + saleRebateMoney +
                ", salePrice=" + salePrice +
                ", serviceFee=" + serviceFee +
                ", profit=" + profit +
                ", departmentProfit=" + departmentProfit +
                ", shoppingTicketPrice=" + shoppingTicketPrice +
                ", shoppingTax=" + shoppingTax +
                ", shoppingRebate=" + shoppingRebate +
                ", shoppingRebateMoney=" + shoppingRebateMoney +
                ", shoppingPrice=" + shoppingPrice +
                ", passengerName='" + passengerName + '\'' +
                ", pnr='" + pnr + '\'' +
                ", ticketStatus='" + ticketStatus + '\'' +
                ", booker='" + booker + '\'' +
                ", ticketDrawer='" + ticketDrawer + '\'' +
                ", channel='" + channel + '\'' +
                ", saleOrderNo='" + saleOrderNo + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentFlownNum='" + paymentFlownNum + '\'' +
                ", tripNo='" + tripNo + '\'' +
                ", settleMentAmount=" + settleMentAmount +
                ", exchangeRate=" + exchangeRate +
                ", currency='" + currency + '\'' +
                ", company='" + company + '\'' +
                ", orderSource='" + orderSource + '\'' +
                '}';
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getSaleDepartment() {
        return saleDepartment;
    }

    public void setSaleDepartment(String saleDepartment) {
        this.saleDepartment = saleDepartment;
    }

    public String getCustomerNameCn() {
        return customerNameCn;
    }

    public void setCustomerNameCn(String customerNameCn) {
        this.customerNameCn = customerNameCn;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getTrip() {
        return trip;
    }

    public void setTrip(String trip) {
        this.trip = trip;
    }

    public String getAirNo() {
        return airNo;
    }

    public void setAirNo(String airNo) {
        this.airNo = airNo;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public Date getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Date issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Date getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
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
        return saleRebateMoney;
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
        return shoppingRebateMoney;
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

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPnr() {
        return pnr;
    }

    public void setPnr(String pnr) {
        this.pnr = pnr;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getBooker() {
        return booker;
    }

    public void setBooker(String booker) {
        this.booker = booker;
    }

    public String getTicketDrawer() {
        return ticketDrawer;
    }

    public void setTicketDrawer(String ticketDrawer) {
        this.ticketDrawer = ticketDrawer;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getSaleOrderNo() {
        return saleOrderNo;
    }

    public void setSaleOrderNo(String saleOrderNo) {
        this.saleOrderNo = saleOrderNo;
    }

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

    public String getTripNo() {
        return tripNo;
    }

    public void setTripNo(String tripNo) {
        this.tripNo = tripNo;
    }

    public BigDecimal getSettleMentAmount() {
        return settleMentAmount;
    }

    public void setSettleMentAmount(BigDecimal settleMentAmount) {
        this.settleMentAmount = settleMentAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public Long getBookerId() {
        return bookerId;
    }

    public void setBookerId(Long bookerId) {
        this.bookerId = bookerId;
    }

    public Long getTicketDrawerId() {
        return ticketDrawerId;
    }

    public void setTicketDrawerId(Long ticketDrawerId) {
        this.ticketDrawerId = ticketDrawerId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Date getCreateSynTime() {
        return createSynTime;
    }

    public void setCreateSynTime(Date createSynTime) {
        this.createSynTime = createSynTime;
    }
}
