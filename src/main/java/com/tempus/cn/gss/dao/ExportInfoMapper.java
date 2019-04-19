package com.tempus.cn.gss.dao;

import com.tempus.cn.gss.bean.form.QueryForm;
import com.tempus.cn.gss.bean.model.ExportInfoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
@author:Administrator
@date:2019/2/28
@description:
@version:1.0
**/
@Repository
public interface ExportInfoMapper {
    Long queryCount(QueryForm queryForm);

    List<ExportInfoModel> pageQuery(QueryForm queryForm);

    void save(ExportInfoModel model);

    void batchSave(List<ExportInfoModel> list);

    List<ExportInfoModel> queryExportInfos(QueryForm queryForm);

    List<ExportInfoModel> queryInfoBySaleOrderNo(String saleOrderNo);

    void deletInfoBySaleOrderNo(String saleOrderNo);
}
