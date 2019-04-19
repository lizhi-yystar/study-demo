package com.tempus.cn.gss.controller;

import com.tempus.cn.gss.bean.form.QueryForm;
import com.tempus.cn.gss.common.Result;
import com.tempus.cn.gss.service.DownLoadExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/downLoad")
public class DownLoadTicketController {

    @Autowired
    DownLoadExcelService downLoadExcelService;

    @RequestMapping("")
    public String page(){
      return "";
    }

    @RequestMapping("/export")
    public Result exportExcel(QueryForm queryParameter, HttpServletResponse response){
        Result result = new Result();
        try {
            result = downLoadExcelService.downLoadExcel(queryParameter,response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode("1");
            result.setMessage("导出失败");
        }
        return result;
    }

}
