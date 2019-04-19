package com.tempus.cn.gss.bean;

import java.io.Serializable;
import java.util.Date;

/**
@author:Administrator
@date:2019/2/28
@description:
@version:
**/
public class LegInfoModel implements Serializable {

    private static final long serialVersionUID = -4507443806180092174L;

    private String legNo;

    private String airLine;

    private String flightNo;

    private String deptAirPort;

    private String stopAirPort;

    private String arrAirPort;

    private Date deptTime;

    private String cabin;

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

    public Date getDeptTime() {
        return deptTime;
    }

    public void setDeptTime(Date deptTime) {
        this.deptTime = deptTime;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getLegNo() {
        return legNo;
    }

    public void setLegNo(String legNo) {
        this.legNo = legNo;
    }
}
