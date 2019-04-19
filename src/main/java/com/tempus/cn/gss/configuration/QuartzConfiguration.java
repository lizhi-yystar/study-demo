package com.tempus.cn.gss.configuration;

import com.tempus.cn.gss.quartz.QuartzJobLauncher;
import org.quartz.Trigger;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class QuartzConfiguration {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobLocator jobLocator;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(Trigger cronJobTrigger){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronJobTrigger);
        Properties quartzProperties = new Properties();
        FileInputStream in = null;
        try {
            Resource resource = new ClassPathResource("quartz.properties");
            String quart= resource.getFile().getPath();
            in = new FileInputStream(quart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            quartzProperties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        Map<String,Object> jobDataMap = new LinkedHashMap<>();
        jobDataMap.put("jobLauncher",jobLauncher);
        jobDataMap.put("jobLocator",jobLocator);
        jobDataMap.put("jobName","synchroniseInfoJob");
        schedulerFactoryBean.setSchedulerContextAsMap(jobDataMap);
        schedulerFactoryBean.setQuartzProperties(quartzProperties);
        return schedulerFactoryBean;
    }

    @Bean
    public CronTriggerFactoryBean getContriggerFactoryBean(/*MethodInvokingJobDetailFactoryBean jobDetailFactoryBean*/){
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setName("contrigger");
        cronTriggerFactoryBean.setGroup("test_group");
        cronTriggerFactoryBean.setCronExpression("0 0/2 * * * ? *");
        cronTriggerFactoryBean.setStartDelay(3000);
        cronTriggerFactoryBean.setJobDetail(getJobDetailFactoryBean().getObject());
        return  cronTriggerFactoryBean;
    }

    @Bean
    public JobDetailFactoryBean getJobDetailFactoryBean(){
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setGroup("corn-group");
        jobDetailFactoryBean.setName("corn");
        jobDetailFactoryBean.setDurability(true);
        jobDetailFactoryBean.setJobClass(QuartzJobLauncher.class);
        return  jobDetailFactoryBean;
    }
    @Bean
    public JobRegistryBeanPostProcessor getJobRegistryBeanPostProcessor(JobRegistry jobRegistry){
        JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor = new JobRegistryBeanPostProcessor();
        jobRegistryBeanPostProcessor.setJobRegistry(jobRegistry);
        return  jobRegistryBeanPostProcessor;
    }
}
