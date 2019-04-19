package com.tempus.cn.gss.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
@author:Administrator
@date:2019/2/28
@description:
@version:1.0
**/
public class OrderDetailInfoModel implements Serializable {

    private static final long serialVersionUID = 801977276156070010L;

    private String saleOrderNo;

    private String ticketNo;

    private String passengerNo;

    private String legNo;

    private BigDecimal cabinPrice;

    private String deptAirPort;

    private String stopAirPort;

    private String arrAirPort;

    private String airLine;

    private String flightNo;

    private String cabin;

    private Date takeOffTime;

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public BigDecimal getCabinPrice() {
        return cabinPrice;
    }

    public void setCabinPrice(BigDecimal cabinPrice) {
        this.cabinPrice = cabinPrice;
    }

    public String getSaleOrderNo() {
        return saleOrderNo;
    }

    public void setSaleOrderNo(String saleOrderNo) {
        this.saleOrderNo = saleOrderNo;
    }

    public String getPassengerNo() {
        return passengerNo;
    }

    public void setPassengerNo(String passengerNo) {
        this.passengerNo = passengerNo;
    }

    public String getLegNo() {
        return legNo;
    }

    public void setLegNo(String legNo) {
        this.legNo = legNo;
    }

    public String getDeptAirPort() {
        return deptAirPort;
    }

    public void setDeptAirPort(String deptAirPort) {
        this.deptAirPort = deptAirPort;
    }

    public String getStopAirPort() {
        return stopAirPort;
    }

    public void setStopAirPort(String stopAirPort) {
        this.stopAirPort = stopAirPort;
    }

    public String getArrAirPort() {
        return arrAirPort;
    }

    public void setArrAirPort(String arrAirPort) {
        this.arrAirPort = arrAirPort;
    }

    public String getAirLine() {
        return airLine;
    }

    public void setAirLine(String airLine) {
        this.airLine = airLine;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public Date getTakeOffTime() {
        return takeOffTime;
    }

    public void setTakeOffTime(Date takeOffTime) {
        this.takeOffTime = takeOffTime;
    }
}
