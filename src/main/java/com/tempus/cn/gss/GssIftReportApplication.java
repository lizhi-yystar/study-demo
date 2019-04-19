package com.tempus.cn.gss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.tempus.cn.gss.dao"})
public class GssIftReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(GssIftReportApplication.class, args);
    }

}
