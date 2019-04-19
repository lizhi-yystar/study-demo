package com.tempus.cn.gss.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
@author:Administrator
@date:2019/2/27
@description:数据库资源配置类
@version:1.0
**/
@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver, @Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.initialSize}") int initSize, @Value("${spring.datasource.minIdle}") int minIdle, @Value("${spring.datasource.maxActive}") int maxActive,
                                      @Value("${spring.datasource.maxWait}") int maxWait, @Value("${spring.datasource.validationQuery}") String validationQuery, @Value("${spring.datasource.testOnBorrow}") boolean testOnBorrow,

                                      @Value("${spring.datasource.username}") String username, @Value("${spring.datasource.password}") String password) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setInitialSize(initSize);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMaxWait(maxWait);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setDefaultAutoCommit(true);
        try {
            //druidDataSource.setFilters("stat, wall");
            druidDataSource.setFilters("stat");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }

}
