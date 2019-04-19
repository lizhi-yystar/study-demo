package com.tempus.cn.gss.service;

import org.apache.poi.xssf.streaming.SXSSFSheet;

public interface WriteExcelDataDelegated {
    void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception;
}
