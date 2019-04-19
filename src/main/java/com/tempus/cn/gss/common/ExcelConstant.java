package com.tempus.cn.gss.common;

/**
@author:Administrator
@date:2019/2/27
@description:控制导出excel的大小
@version:1.0
**/
public class ExcelConstant {
    /**
     * 每个sheet存储的记录数 100W
     */
    public static final Integer PER_SHEET_ROW_COUNT = 1000;

    /**
     * 每次向EXCEL写入的记录数(查询每页数据大小) 20W
     */
    public static final Integer PER_WRITE_ROW_COUNT = 200;


    /**
     * 每个sheet的写入次数 5
     */
    public static final Integer PER_SHEET_WRITE_COUNT = PER_SHEET_ROW_COUNT / PER_WRITE_ROW_COUNT;
}
