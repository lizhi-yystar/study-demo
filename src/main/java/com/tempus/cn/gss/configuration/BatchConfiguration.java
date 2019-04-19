package com.tempus.cn.gss.configuration;

import com.tempus.cn.gss.bean.BaseInfoModel;
import com.tempus.cn.gss.bean.ItemWriteModel;
import com.tempus.cn.gss.listener.JobCompletionNotificationListener;
import com.tempus.cn.gss.processor.ExportInfoModelProcessor;
import com.tempus.cn.gss.writer.ExportInfoModelWriter;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableBatchProcessing
@Import(QuartzConfiguration.class)
public class BatchConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(BatchConfiguration.class);

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Autowired
    JobCompletionNotificationListener jobListener;

    @Autowired
    DataSource dataSource;

   @Bean
   public ItemReader<BaseInfoModel> createReader(){
       //BaseInfoReader reader = new BaseInfoReader();
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
       jobParameters.put("startDate","2018-01-01");
       /*jobParameters.put("endDate","2019-12-31 23:59:59");*/
       jobParameters.put("pageSize",30);
       myBatisPagingItemReader.setParameterValues(jobParameters);
       try {
           myBatisPagingItemReader.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
       } catch (Exception e) {
           logger.error("e",e);
       }
       return myBatisPagingItemReader;
   }

    @Bean
    public ExportInfoModelProcessor exportInfoModelProcessor() {
        return new ExportInfoModelProcessor();
    }

    @Bean
    public ExportInfoModelWriter exportInfoModelWriter(){
        return new ExportInfoModelWriter();
    }

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionNotificationListener();
    }

    // Configure job step
    @Bean
    public Job fxMarketPricesETLJob() {
        return jobBuilderFactory.get("synchroniseInfoJob").incrementer(new RunIdIncrementer()).listener(listener())
                .flow(workStep()).end().build();
    }

    @Bean
    public Step workStep() {
        return stepBuilderFactory.get("Extract -> Transform -> Aggregate -> Load").allowStartIfComplete(true)
                .<BaseInfoModel, ItemWriteModel> chunk(100)
                .reader(createReader())
                .processor(exportInfoModelProcessor())
                .writer(exportInfoModelWriter()).build();
    }
}
