package com.tempus.cn.gss.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static String formatDate(Date date, String pattern){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    public static Date strToDate(String pattern,String dateStr){
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        Date date= new Date();
        try {
            date = format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args){
        BigDecimal a = new BigDecimal(1289.15);
        System.out.println(String.valueOf(a));
    }
}
