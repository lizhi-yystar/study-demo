package com.tempus.cn.gss.processor;

import com.tempus.cn.gss.bean.*;
import com.tempus.cn.gss.bean.model.ExportInfoModel;
import com.tempus.cn.gss.dao.BuyOrderInfoMapper;
import com.tempus.cn.gss.dao.OrderInfoMapper;
import com.tempus.cn.gss.dao.PaymentMapper;
import com.tempus.cn.gss.dao.UserInfoMapper;
import com.tempus.cn.gss.util.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
@author:Administrator
@date:2019/3/6
@description:
@version:1.0
**/
public class ExportInfoModelProcessor implements ItemProcessor<BaseInfoModel,ItemWriteModel> {

    private static final Logger logger = LoggerFactory.getLogger(ExportInfoModelProcessor.class);

    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    PaymentMapper paymentMapper;
    @Autowired
    BuyOrderInfoMapper buyOrderInfoMapper;

    @Override
    public ItemWriteModel process(BaseInfoModel baseInfoModel) throws Exception {
        logger.info("baseInfoModel:" + baseInfoModel.toString());
        String saleOrderNo = baseInfoModel.getSaleOrderNo();
        ItemWriteModel writeModel = new ItemWriteModel();
        writeModel.setSaleOrderNo(saleOrderNo);
        Map legInfoMap = new HashMap();
        Map innerMap = new HashMap();
        Map psgMap = new HashMap();
        List<PassengerInfoModel> passengerInfoModels = orderInfoMapper.queryPassengerInfoBySaleOrderNo(saleOrderNo);
        List<OrderDetailInfoModel> detailsAndLegs = orderInfoMapper.queryTicketLegDetails(saleOrderNo);
        String tempTrip = "";
        String cabins = "";
        Date createTime = new Date();
        /**
         * 将乘客和票号，票号和航段对应起来
         */
        for (PassengerInfoModel psgModel : passengerInfoModels) {
            for (OrderDetailInfoModel detail : detailsAndLegs) {
                String cabin = detail.getCabin()==null?"Y":detail.getCabin();
                if (StringUtils.equals(detail.getPassengerNo(),psgModel.getPassengerNo())) {
                    //map不包含票号，将票号和航段对保存
                    if (!innerMap.containsKey(detail.getTicketNo())) {
                        tempTrip = DateUtils.formatDate(detail.getTakeOffTime(),DateUtils.YYYY_MM_DD_HH_MM_SS);
                        if (!StringUtils.isEmpty(detail.getStopAirPort())) {
                            tempTrip = tempTrip + "TIME/TRIP" + detail.getDeptAirPort() + "-" + detail.getStopAirPort() + "-" + detail.getArrAirPort();
                        } else {
                            tempTrip = tempTrip + "TIME/TRIP" + detail.getDeptAirPort() + "-" + detail.getArrAirPort();
                        }
                        innerMap.put(detail.getTicketNo(), tempTrip);
                    } else {
                        String trip = (String) innerMap.get(detail.getTicketNo());
                        String temp = detail.getDeptAirPort() + "-" + detail.getArrAirPort();
                        //不包含此航段，继续将航段拼接在一起
                        if(!trip.contains(temp)){
                            trip = trip + "," + detail.getDeptAirPort() + "-" + detail.getArrAirPort();
                        }
                        innerMap.put(detail.getTicketNo(), trip);
                    }
                    psgMap.put(psgModel.getPassengerNo(), innerMap);
                }
                //提取航段，航班和舱位
                if (legInfoMap.containsKey(detail.getTicketNo())) {
                    String flight = (String) legInfoMap.get(detail.getTicketNo());
                    String[] flightArray = flight.split(":");
                    if(!flightArray[0].contains(detail.getAirLine())){
                        flight= flightArray[0]+","+detail.getAirLine()+":"+flightArray[1]+","+detail.getFlightNo();
                    }
                    if(!cabins.contains(cabin)){
                        if(cabins.length()>0){
                            cabins = cabins + ",";
                        }
                        cabins = cabins + cabin;
                    }
                    flight = flight + '/' +cabins;
                    legInfoMap.put(detail.getTicketNo(),flight);
                } else {
                    String flight = detail.getAirLine() + ":" + detail.getFlightNo();
                    if(!cabins.contains(cabin)){
                        if(cabins.length()>0){
                            cabins = cabins + ",";
                        }
                        cabins = cabins + cabin;
                    }
                    flight = flight + '/' + cabins;
                    legInfoMap.put(detail.getTicketNo(), flight);
                }
            }
        }
        //提取航段信息
        List<LegInfoModel> legInfos = orderInfoMapper.queryLegInfoBySaleOrderNo(saleOrderNo);
        //Date takeOffTime = legInfos.get(0).getDeptTime();

        UserInfo salesPerSon = userInfoMapper.queryUserName(String.valueOf(baseInfoModel.getLocker()));
        BuyOrderInfoModel buyOrderInfo = buyOrderInfoMapper.qeuryBuyOrderInfo(saleOrderNo);
        UserInfo ticketDrawer = userInfoMapper.queryUserName(buyOrderInfo.getBuyLocker());

        List<PaymentInfoModel> paymentInfos = paymentMapper.queryPaymentInfo(saleOrderNo);
        CustomerInfoModel customer = userInfoMapper.queryCustomerInfo(baseInfoModel.getCustomerNo());
        List<ExportInfoModel> exportInfoModels = new ArrayList<>();
        for (PassengerInfoModel psg : passengerInfoModels) {
            Map ticketsMap = (Map) psgMap.get(psg.getPassengerNo());
            ticketsMap.forEach((key, value) -> {
                ExportInfoModel exportInfoModel = constructExportInfo(baseInfoModel,customer);
                BeanUtils.copyProperties(psg, exportInfoModel);
                logger.info("saleOrderNo:{},customerNo:{},ticketNo:{}",saleOrderNo,baseInfoModel.getCustomerNo(),key);
                if(salesPerSon==null){
                    exportInfoModel.setBooker("未找到对应销售员");
                    exportInfoModel.setSaleDepartment("未找到对应销售部门");
                    exportInfoModel.setDepartmentId(0);
                    exportInfoModel.setBookerId(0L);
                }else{
                    exportInfoModel.setBooker(salesPerSon.getUserName());
                    exportInfoModel.setBookerId(salesPerSon.getUserId());
                    exportInfoModel.setDepartmentId(salesPerSon.getDepartmentId());
                    exportInfoModel.setSaleDepartment(salesPerSon.getDepartmentName());
                }
                if(ticketDrawer==null){
                    exportInfoModel.setTicketDrawer("未找到对应出票员");
                    exportInfoModel.setTicketDrawerId(0L);
                }else{
                    exportInfoModel.setTicketDrawer(ticketDrawer.getUserName());
                    exportInfoModel.setTicketDrawerId(ticketDrawer.getUserId());
                }
                exportInfoModel.setTicketNo((String) key);
                exportInfoModel.setChannel(buyOrderInfo.getChannel());
                String[] valArray = value.toString().split( "TIME/TRIP");
                exportInfoModel.setTrip(valArray[1]);
                String flightInfo = (String) legInfoMap.get(key);
                String[] flightArray = flightInfo.split(":");
                String[] result = flightArray[1].split("/");
                exportInfoModel.setCarrier(flightArray[0]);
                exportInfoModel.setAirNo(result[0]);
                exportInfoModel.setTakeOffTime(DateUtils.strToDate(DateUtils.YYYY_MM_DD_HH_MM_SS,valArray[0]));
                exportInfoModel.setSeat(result[1]);
                exportInfoModel.setCreateSynTime(createTime);
                String flownNum = "";
                String paymentMethod ="";
                if(paymentInfos.size()==0){
                    flownNum = "支付流水为空";
                    paymentMethod = "支付流水为空";
                }else{
                    flownNum = paymentInfos.get(0).getPaymentFlownNum();
                    paymentMethod = paymentInfos.get(0).getPaymentMethod();
                }
                exportInfoModel.setPaymentFlownNum(flownNum);
                exportInfoModel.setPaymentMethod(paymentMethod);
                exportInfoModels.add(exportInfoModel);
            });
        }
        writeModel.setResultList(exportInfoModels);
        return writeModel;
    }

    /**
     * 创建报表保存对象  并设置相关值
     * @param baseInfoModel
     * @param customer
     * @return
     */
    private ExportInfoModel constructExportInfo(BaseInfoModel baseInfoModel,CustomerInfoModel customer){
        ExportInfoModel exportInfoModel = new ExportInfoModel();
        exportInfoModel.setCurrency(baseInfoModel.getSaleCurrency());
        exportInfoModel.setExchangeRate(baseInfoModel.getExchangeRate());
        exportInfoModel.setSaleOrderNo(baseInfoModel.getSaleOrderNo());
        exportInfoModel.setIssuedTime(baseInfoModel.getIssueTime());
        exportInfoModel.setCompany(baseInfoModel.getCompany());
        exportInfoModel.setCustomerNo(baseInfoModel.getCustomerNo());
        exportInfoModel.setCustomerNameCn(customer.getCustomerName());
        exportInfoModel.setOrderSource(customer.getOrderSource());
        return exportInfoModel;
    }
}
