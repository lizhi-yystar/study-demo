package com.tempus.cn.gss.bean.form;

import java.io.Serializable;

/**
@author:Administrator
@date:2019/3/6
@description:查询参数
@version:1.0
**/
public class QueryForm implements Serializable {
    private static final long serialVersionUID = -2356787085852555231L;

    private String startDate;
    private String endDate;

    /**
     * 供应商
     */
    private String supplierName;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 出票日期
     */
    private String ticketDateStart;
    private String ticketDateEnd;
    /**
     * 单号
     */
    private String saleOrderNo;
    /**
     * 票号
     */
    private String ticketNo;
    /**
     * 航程
     */
    private String routing;
    /**
     * 航班号
     */
    private String flightNo;
    /**
     * 舱位
     */
    private String[] cabins;
    /**
     * 起飞日期
     */
    private String depDateStart;
    private String depDateEnd;
    /**
     * 售票员
     */
    private String salePerson;
    /**
     * 出票部门
     */
    private String[] saleDept;
    /**
     * 出票员
     */
    private String ticketPerson;
    /**
     * 所属公司
     */
    private String company;
    /**
     * 旅客姓名
     */
    private String passengerName;
    /**
     * 姓
     */
    private String surname;
    /**
     * 名
     */
    private String name;

    /**
     * 订单来源
     */
    private String[] source;
    /**
     * 多状态查询条件
     */
    private Integer[] orderStatusArray;

    /**
     *客户编号
     */
    private String customerNo;
    private Integer currentIndex;
    private Integer pageSize;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTicketDateStart() {
        return ticketDateStart;
    }

    public void setTicketDateStart(String ticketDateStart) {
        this.ticketDateStart = ticketDateStart;
    }

    public String getTicketDateEnd() {
        return ticketDateEnd;
    }

    public void setTicketDateEnd(String ticketDateEnd) {
        this.ticketDateEnd = ticketDateEnd;
    }

    public String getSaleOrderNo() {
        return saleOrderNo;
    }

    public void setSaleOrderNo(String saleOrderNo) {
        this.saleOrderNo = saleOrderNo;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public String getRouting() {
        return routing;
    }

    public void setRouting(String routing) {
        this.routing = routing;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String[] getCabins() {
        return cabins;
    }

    public void setCabins(String[] cabins) {
        this.cabins = cabins;
    }

    public String getDepDateStart() {
        return depDateStart;
    }

    public void setDepDateStart(String depDateStart) {
        this.depDateStart = depDateStart;
    }

    public String getDepDateEnd() {
        return depDateEnd;
    }

    public void setDepDateEnd(String depDateEnd) {
        this.depDateEnd = depDateEnd;
    }

    public String getSalePerson() {
        return salePerson;
    }

    public void setSalePerson(String salePerson) {
        this.salePerson = salePerson;
    }

    public String[] getSaleDept() {
        return saleDept;
    }

    public void setSaleDept(String[] saleDept) {
        this.saleDept = saleDept;
    }

    public String getTicketPerson() {
        return ticketPerson;
    }

    public void setTicketPerson(String ticketPerson) {
        this.ticketPerson = ticketPerson;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSource() {
        return source;
    }

    public void setSource(String[] source) {
        this.source = source;
    }

    public Integer[] getOrderStatusArray() {
        return orderStatusArray;
    }

    public void setOrderStatusArray(Integer[] orderStatusArray) {
        this.orderStatusArray = orderStatusArray;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
