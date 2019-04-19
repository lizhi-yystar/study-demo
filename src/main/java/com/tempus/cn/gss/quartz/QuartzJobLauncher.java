package com.tempus.cn.gss.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.Serializable;

public class QuartzJobLauncher extends QuartzJobBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(QuartzJobLauncher.class);

    private String jobName;
    private JobRepository repository;
    private JobLauncher jobLauncher;
    private JobLocator jobLocator;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
       try {
           Job job = jobLocator.getJob(jobName);
           JobExecution jobExecution = jobLauncher.run(job,new JobParameters());
           logger.info("{}_{} compeleted successfully",jobName,jobExecution.getId());
       }catch (Exception e){
           logger.error("QuartzJobLauncher",e);
       }
    }

    public JobRepository getRepository() {
        return repository;
    }

    public void setRepository(JobRepository repository) {
        this.repository = repository;
    }

    public JobLauncher getJobLauncher() {
        return jobLauncher;
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public JobLocator getJobLocator() {
        return jobLocator;
    }

    public void setJobLocator(JobLocator jobLocator) {
        this.jobLocator = jobLocator;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
}
