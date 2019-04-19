package com.tempus.cn.gss.util;

import com.tempus.cn.gss.common.ExcelConstant;
import com.tempus.cn.gss.service.WriteExcelDataDelegated;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class PoiUtil {

    private static final  Logger logger = LoggerFactory.getLogger(PoiUtil.class);

    /**
     * 初始化EXCEL(sheet个数和标题)
     *
     * @param totalRowCount 总记录数
     * @param titles        标题集合
     * @return XSSFWorkbook对象
     */
    public static SXSSFWorkbook initExcel(Long totalRowCount, String[] titles) {
        // 在内存当中保持 100 行 , 超过的数据放到硬盘中在内存当中保持 100 行 , 超过的数据放到硬盘中
        SXSSFWorkbook wb = new SXSSFWorkbook(100);
        //得到总的sheet数量
        Long sheetCount = ((totalRowCount % ExcelConstant.PER_SHEET_ROW_COUNT == 0) ?
                (totalRowCount / ExcelConstant.PER_SHEET_ROW_COUNT) : (totalRowCount / ExcelConstant.PER_SHEET_ROW_COUNT + 1));
        // 根据得到的sheet数，创建sheet并分配标题
        for (int i = 0; i < sheetCount; i++) {
            SXSSFSheet sheet = wb.createSheet("sheet" + (i + 1));
            SXSSFRow headRow = sheet.createRow(0);
            for (int j = 0; j < titles.length; j++) {
                SXSSFCell headRowCell = headRow.createCell(j);
                headRowCell.setCellValue(titles[j]);
            }
        }
        return wb;
    }


    /**
     * 下载EXCEL到本地指定的文件夹
     *
     * @param wb         EXCEL对象SXSSFWorkbook
     * @param exportPath 导出路径
     */
    public static void downLoadExcelToLocalPath(SXSSFWorkbook wb, String exportPath) {
        FileOutputStream fops = null;
        try {
            fops = new FileOutputStream(exportPath);
            wb.write(fops);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != wb) {
                try {
                    wb.dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != fops) {
                try {
                    fops.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 下载EXCEL到浏览器
     *
     * @param wb       EXCEL对象XSSFWorkbook
     * @param response
     * @param fileName 文件名称
     * @throws IOException
     */
    public static void downLoadExcelToWebsite(SXSSFWorkbook wb, HttpServletResponse response, String fileName) throws IOException {
        response.setHeader("Content-disposition", "attachment; filename="
                + new String((fileName + ".xlsx").getBytes("utf-8"), "ISO8859-1"));//设置下载的文件名

        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            wb.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != wb) {
                try {
                    wb.dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (null != outputStream) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 导出Excel到本地指定路径
     *
     * @param totalRowCount           总记录数
     * @param titles                  标题
     * @param exportPath              导出路径
     * @param writeExcelDataDelegated 向EXCEL写数据/处理格式的委托类 自行实现
     * @throws Exception
     */
    public static final void exportExcelToLocalPath(Long totalRowCount, String[] titles, String exportPath, WriteExcelDataDelegated writeExcelDataDelegated) throws Exception {
        logger.info("开始导出：" + DateUtils.formatDate(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS));
        // 初始化EXCEL
        SXSSFWorkbook wb = PoiUtil.initExcel(totalRowCount, titles);
        // 调用委托类分批写数据
        int sheetCount = wb.getNumberOfSheets();
        for (int i = 0; i < sheetCount; i++) {
            SXSSFSheet eachSheet = wb.getSheetAt(i);
            for (int j = 1; j <= ExcelConstant.PER_SHEET_WRITE_COUNT; j++) {
                int currentPage = i * ExcelConstant.PER_SHEET_WRITE_COUNT + j;
                int pageSize = ExcelConstant.PER_WRITE_ROW_COUNT;
                int startRowCount = (j - 1) * ExcelConstant.PER_WRITE_ROW_COUNT + 1;
                int endRowCount = startRowCount + pageSize - 1;
                writeExcelDataDelegated.writeExcelData(eachSheet, startRowCount, endRowCount, currentPage, pageSize);
            }
        }
        // 下载EXCEL
        PoiUtil.downLoadExcelToLocalPath(wb, exportPath);
        logger.info("导出完成：" + DateUtils.formatDate(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS));
    }


    /**
     * 导出Excel到浏览器
     *
     * @param response
     * @param totalRowCount           总记录数
     * @param fileName                文件名称
     * @param titles                  标题
     * @param writeExcelDataDelegated 向EXCEL写数据/处理格式的委托类 自行实现
     * @throws Exception
     */
    public static final void exportExcelToWebsite(HttpServletResponse response, Long totalRowCount, String fileName, String[] titles, WriteExcelDataDelegated writeExcelDataDelegated) throws Exception {
        logger.info("开始导出：" + DateUtils.formatDate(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS));
        // 初始化EXCEL
        SXSSFWorkbook wb = PoiUtil.initExcel(totalRowCount, titles);
        // 调用委托类分批写数据
        int sheetCount = wb.getNumberOfSheets();
        for (int i = 0; i < sheetCount; i++) {
            SXSSFSheet eachSheet = wb.getSheetAt(i);
            for (int j = 1; j <= ExcelConstant.PER_SHEET_WRITE_COUNT; j++) {
                //当前页数 = 当前sheet下标  * 每个sheet写满需要写的次数 + 属于第几次写当前sheet
                int currentPage = i * ExcelConstant.PER_SHEET_WRITE_COUNT + j;
                int pageSize = ExcelConstant.PER_WRITE_ROW_COUNT;
                //startRowCount 当前sheet开始本次写时的行数
                int startRowCount = (j - 1) * ExcelConstant.PER_WRITE_ROW_COUNT + 1;
                int endRowCount = startRowCount + pageSize - 1;
                writeExcelDataDelegated.writeExcelData(eachSheet, startRowCount, endRowCount, currentPage, pageSize);
            }
        }
        // 下载EXCEL
        PoiUtil.downLoadExcelToWebsite(wb, response, fileName);
        logger.info("导出完成：" + DateUtils.formatDate(new Date(), DateUtils.YYYY_MM_DD_HH_MM_SS));
    }

}
