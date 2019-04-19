package com.tempus.cn.gss.service.impl;

import com.tempus.cn.gss.bean.form.QueryForm;
import com.tempus.cn.gss.bean.model.ExportInfoModel;
import com.tempus.cn.gss.common.Result;
import com.tempus.cn.gss.dao.ExportInfoMapper;
import com.tempus.cn.gss.service.DownLoadExcelService;
import com.tempus.cn.gss.service.WriteExcelDataDelegated;
import com.tempus.cn.gss.util.DateUtils;
import com.tempus.cn.gss.util.PoiUtil;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
@author:Administrator
@date:2019/2/28
@description:报表导出服务
@version:1.0
**/
@Service
public class DownLoadServiceImpl implements DownLoadExcelService {

    @Autowired
    ExportInfoMapper exportInfoMapper;

    @Override
    public Result downLoadExcel(QueryForm queryParameter, HttpServletResponse response) throws Exception {
        String fileName = "国际出票报表";
        String[] titles = {"销售部门","客户名称","客户编号","承运人","票号","航程","航班",
                "仓位","出票日期","乘机日期","销售票价","销售税费","销售返点","销售返利",
                "应收金额","服务费","毛利","营业部毛利",
                "采购票价","采购税费","采购返点","采购返利","采购应收金额","乘机人","PNR",
                "机票状态","订票人","出票人","出票渠道","订单号","支付方式","流水号","行程单号",
                "结算金额","汇率","币种","所属公司","订单来源"};
        Long totalNum = exportInfoMapper.queryCount(queryParameter);

        PoiUtil.exportExcelToWebsite(response, totalNum, fileName, titles, new WriteExcelDataDelegated() {
            @Override
            public void writeExcelData(SXSSFSheet eachSheet, Integer startRowCount, Integer endRowCount, Integer currentPage, Integer pageSize) throws Exception {
                queryParameter.setCurrentIndex((currentPage-1)*pageSize);
                queryParameter.setPageSize(pageSize);
                List<ExportInfoModel> list = exportInfoMapper.queryExportInfos(queryParameter);
                if(!CollectionUtils.isEmpty(list)){
                    for (int i = startRowCount; i <= endRowCount; i++) {
                        SXSSFRow eachDataRow = eachSheet.createRow(i);
                        if ((i - startRowCount) < list.size()) {
                            ExportInfoModel exportInfo = list.get(i - startRowCount);
                            //销售部门
                            eachDataRow.createCell(0).setCellValue(exportInfo.getSaleDepartment() == null ? "" : exportInfo.getSaleDepartment());
                            //客户名称
                            eachDataRow.createCell(1).setCellValue(exportInfo.getCustomerNameCn() == null ? "" : exportInfo.getCustomerNameCn());
                            //客户编号
                            eachDataRow.createCell(2).setCellValue(exportInfo.getCustomerNo() == null ? "" : exportInfo.getCustomerNo());
                            //承运人
                            eachDataRow.createCell(3).setCellValue(exportInfo.getCarrier() == null ? "" : exportInfo.getCarrier());
                            //票号
                            eachDataRow.createCell(4).setCellValue(exportInfo.getTicketNo() == null ? "" : exportInfo.getTicketNo());
                            //航程
                            eachDataRow.createCell(5).setCellValue(exportInfo.getTrip() == null ? "" : exportInfo.getTrip());
                            //航班
                            eachDataRow.createCell(6).setCellValue(exportInfo.getAirNo() ==null ?  "" : exportInfo.getAirNo());
                            //仓位
                            eachDataRow.createCell(7).setCellValue(exportInfo.getSeat() == null ? "" : exportInfo.getSeat());
                            //出票日期
                            eachDataRow.createCell(8).setCellValue(DateUtils.formatDate(exportInfo.getIssuedTime(),DateUtils.YYYY_MM_DD_HH_MM_SS));
                            //乘机日期
                            eachDataRow.createCell(9).setCellValue(DateUtils.formatDate(exportInfo.getTakeOffTime(),DateUtils.YYYY_MM_DD_HH_MM_SS));
                            //销售票价
                            eachDataRow.createCell(10).setCellValue(exportInfo.getSaleTicketPrice() == null ? "0" : String.valueOf(exportInfo.getSaleTicketPrice().doubleValue()));
                            //销售税费
                            eachDataRow.createCell(11).setCellValue(exportInfo.getSaleTax() == null ? "0" : String.valueOf( exportInfo.getSaleTax().doubleValue()));
                            //销售返点
                            eachDataRow.createCell(12).setCellValue(exportInfo.getSaleRebate() == null ? "0" : String.valueOf(exportInfo.getSaleTax().doubleValue()));
                            //销售返利
                            eachDataRow.createCell(13).setCellValue(exportInfo.getSaleRebateMoney() == null ? "0" : String.valueOf(exportInfo.getSaleRebateMoney().doubleValue()));
                            //应收金额
                            eachDataRow.createCell(14).setCellValue(exportInfo.getSalePrice() == null ? "0" : String.valueOf(exportInfo.getSalePrice().doubleValue()));
                            //服务费
                            eachDataRow.createCell(15).setCellValue(exportInfo.getServiceFee() == null ? "0" : String.valueOf(exportInfo.getServiceFee().doubleValue()));
                            //毛利
                            eachDataRow.createCell(16).setCellValue(exportInfo.getProfit() == null ? "0" : String.valueOf(exportInfo.getProfit().doubleValue()));
                            //营业部毛利
                            eachDataRow.createCell(17).setCellValue(exportInfo.getDepartmentProfit() == null ? "0" : String.valueOf(exportInfo.getDepartmentProfit().doubleValue()));
                            //采购票价
                            eachDataRow.createCell(18).setCellValue(exportInfo.getShoppingTicketPrice() == null ? "0" : String.valueOf(exportInfo.getShoppingTicketPrice().doubleValue()));
                            //采购税费
                            eachDataRow.createCell(19).setCellValue(exportInfo.getShoppingTax() == null ? "0" : String.valueOf(exportInfo.getShoppingTax().doubleValue()));
                            //采购返点
                            eachDataRow.createCell(20).setCellValue(exportInfo.getShoppingRebate() == null ? "0" : String.valueOf(exportInfo.getShoppingRebate().doubleValue()));
                            //采购返利
                            eachDataRow.createCell(21).setCellValue(exportInfo.getShoppingRebateMoney() == null ? "0" : String.valueOf(exportInfo.getShoppingRebateMoney().doubleValue()));
                            //采购应收金额
                            eachDataRow.createCell(22).setCellValue(exportInfo.getShoppingPrice() == null ? "0" : String.valueOf(exportInfo.getShoppingPrice().doubleValue()));
                            //乘机人
                            eachDataRow.createCell(23).setCellValue(exportInfo.getPassengerName() == null ? "" : exportInfo.getPassengerName());
                            //PNR
                            eachDataRow.createCell(24).setCellValue(exportInfo.getPnr() == null ? "" : exportInfo.getPnr());
                            //机票状态
                            eachDataRow.createCell(25).setCellValue("已出票");
                            //订票人
                            eachDataRow.createCell(26).setCellValue(exportInfo.getBooker() == null ? "" : exportInfo.getBooker());
                            //出票人
                            eachDataRow.createCell(27).setCellValue(exportInfo.getTicketDrawer() == null ? "" : exportInfo.getTicketDrawer());
                            //出票渠道
                            eachDataRow.createCell(28).setCellValue(exportInfo.getChannel() == null ? "" : exportInfo.getChannel());
                            //订单号
                            eachDataRow.createCell(29).setCellValue(exportInfo.getSaleOrderNo() == null ? "" : exportInfo.getSaleOrderNo());
                            //支付方式
                            eachDataRow.createCell(30).setCellValue(exportInfo.getPaymentMethod() == null ? "" : exportInfo.getPaymentMethod());
                            //流水号
                            eachDataRow.createCell(31).setCellValue(exportInfo.getPaymentFlownNum() == null ? "" : exportInfo.getPaymentFlownNum());
                            //行程单号
                            eachDataRow.createCell(32).setCellValue(exportInfo.getTripNo() == null ? "" : exportInfo.getTripNo());
                            //结算金额
                            eachDataRow.createCell(33).setCellValue(exportInfo.getSettleMentAmount() == null ? "0" : String.valueOf(exportInfo.getSettleMentAmount().doubleValue()));
                            //汇率
                            eachDataRow.createCell(34).setCellValue(exportInfo.getExchangeRate() == null ? "1.0" : String.valueOf(exportInfo.getExchangeRate().doubleValue()));
                            //币种
                            eachDataRow.createCell(35).setCellValue(exportInfo.getCurrency() == null ? "CNY" : exportInfo.getCurrency());
                            //所属公司
                            eachDataRow.createCell(36).setCellValue(exportInfo.getCompany() == null ? "" : exportInfo.getCompany());
                            //订单来源
                            eachDataRow.createCell(37).setCellValue(exportInfo.getOrderSource() == null ? "" : exportInfo.getOrderSource());
                        }
                    }
                }
            }
        });
        Result result = new Result();
        result.setCode("0");
        result.setMessage("导出成功");
        return result;
    }
}
