/*
package com.tempus.cn.gss.reader;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseInfoReader extends MyBatisPagingItemReader {

    @Autowired
    DataSource dataSource;

    public BaseInfoReader(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/*Mapper.xml"));
        } catch (IOException e) {
            logger.error("sqlSessionFactoryBean的setMapperLocations有问题",e);
        }
        MyBatisPagingItemReader myBatisPagingItemReader = new MyBatisPagingItemReader();
        myBatisPagingItemReader.setPageSize(50);
        myBatisPagingItemReader.setQueryId("com.tempus.cn.gss.dao.BaseInfoMapper.pageQuery");
        Map jobParameters = new HashMap();
        jobParameters.put("startDate","2018-01-01 00:00:00");
        */
/*jobParameters.put("endDate","2019-12-31 23:59:59");*//*

        jobParameters.put("pageSize",30);
        myBatisPagingItemReader.setParameterValues(jobParameters);
        try {
            myBatisPagingItemReader.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
*/
