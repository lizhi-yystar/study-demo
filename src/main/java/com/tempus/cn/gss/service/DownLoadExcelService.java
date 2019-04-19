package com.tempus.cn.gss.service;

import com.tempus.cn.gss.bean.form.QueryForm;
import com.tempus.cn.gss.common.Result;
import org.hibernate.query.QueryParameter;

import javax.servlet.http.HttpServletResponse;

public interface DownLoadExcelService {

    Result downLoadExcel(QueryForm queryParameter, HttpServletResponse response) throws Exception;
}
