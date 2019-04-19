package com.tempus.cn.gss;

import com.tempus.cn.gss.bean.model.ExportInfoModel;
import com.tempus.cn.gss.dao.ExportInfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GssIftReportApplicationTests {

    @Autowired
    ExportInfoMapper exportInfoMapper;


    @Test
    public void contextLoads() {
      /*  ExportInfoModel model = new ExportInfoModel();
        model.setPaymentMethod("信用");
        model.setPaymentFlownNum("343242342343");
        model.setSeat("Y");
        model.setTakeOffTime(new Date());
        model.setCustomerNameCn("test");
        model.setCustomerNo("48940464045647894");
        model.setCarrier("UO");
        model.setAirNo("7894");
        model.setTrip("OKU-CHD");
        model.setTicketNo("990-456454894");
        model.setSaleDepartment("amiba");
        model.setTicketDrawer("test");
        model.setBooker("test");
        model.setSaleOrderNo("4235234234");
        model.setCurrency("CNY");
        model.setExchangeRate(new BigDecimal(1.0));
        model.setChannel("OP");
        model.setCompany("test");
        model.setDepartmentProfit(new BigDecimal(100));
        model.setIssuedTime(new Date());
        model.setOrderSource("test");
        model.setPassengerName("test");
        model.setPnr("KO098Y");
        model.setProfit(new BigDecimal(20));
        model.setSalePrice(new BigDecimal(300));
        model.setSaleRebate(new BigDecimal(33));
        model.setSaleRebateMoney(new BigDecimal(110));
        model.setSaleTax(new BigDecimal(22));
        model.setSaleTicketPrice(new BigDecimal(999));
        model.setServiceFee(new BigDecimal(10));
        model.setSettleMentAmount(new BigDecimal(1230));
        model.setShoppingRebate(new BigDecimal(897));
        model.setShoppingPrice(new BigDecimal(0));
        model.setShoppingRebateMoney(new BigDecimal(23423));
        model.setShoppingTax(new BigDecimal(333));
        model.setShoppingTicketPrice(new BigDecimal(998));
        model.setTicketStatus("已出票");

        exportInfoMapper.save(model);

        List<ExportInfoModel> list = new ArrayList<>();
        list.add(model);
        exportInfoMapper.batchSave(list);*/
    }

}
