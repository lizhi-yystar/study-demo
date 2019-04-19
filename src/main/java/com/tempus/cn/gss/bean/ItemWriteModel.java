package com.tempus.cn.gss.bean;

import com.tempus.cn.gss.bean.model.ExportInfoModel;

import java.io.Serializable;
import java.util.List;

public class ItemWriteModel implements Serializable {
    private static final long serialVersionUID = -3552745999513149403L;

    private String saleOrderNo;

    private List<ExportInfoModel> resultList;

    public List<ExportInfoModel> getResultList() {
        return resultList;
    }

    public void setResultList(List<ExportInfoModel> resultList) {
        this.resultList = resultList;
    }

    public String getSaleOrderNo() {
        return saleOrderNo;
    }

    public void setSaleOrderNo(String saleOrderNo) {
        this.saleOrderNo = saleOrderNo;
    }
}
