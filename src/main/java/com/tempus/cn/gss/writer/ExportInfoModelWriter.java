package com.tempus.cn.gss.writer;

import com.tempus.cn.gss.bean.ItemWriteModel;
import com.tempus.cn.gss.bean.model.ExportInfoModel;
import com.tempus.cn.gss.dao.BaseInfoMapper;
import com.tempus.cn.gss.dao.ExportInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
@author:Administrator
@date:2019/3/6
@description:将组装好的报表数据入库
@version:1.0
**/
public class ExportInfoModelWriter implements ItemWriter<ItemWriteModel> {

    private static final Logger logger = LoggerFactory.getLogger(ExportInfoModelWriter.class);

    @Autowired
    ExportInfoMapper exportInfoMapper;
    @Autowired
    BaseInfoMapper baseInfoMapper;

    @Override
    public void write(List<? extends ItemWriteModel> list) throws Exception {
           logger.info("批量写入报表数据开始...");
           ItemWriteModel  result = list.get(0);
           List<ExportInfoModel> exportInfoModels = result.getResultList();
           if(exportInfoModels.size()>0) {
               //检查是否已存在报表中 若存在删除旧数据 保存信息数据
               String saleOrderNo = result.getSaleOrderNo();
               List<ExportInfoModel> summaryInfo = exportInfoMapper.queryInfoBySaleOrderNo(saleOrderNo);
               if(summaryInfo!=null && summaryInfo.size()>0){
                  exportInfoMapper.deletInfoBySaleOrderNo(saleOrderNo);
               }
               exportInfoMapper.batchSave(exportInfoModels);
               baseInfoMapper.updateSynchronizeStatus(saleOrderNo);
           }
    }
}
