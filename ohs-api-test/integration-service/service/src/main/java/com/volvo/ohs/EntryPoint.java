package com.volvo.ohs;
 
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;
 
@SpringBootApplication
public class EntryPoint {
    @Autowired
    JobLauncher jobLauncher;
      
    @Autowired
    Job job;
    
	public static void main(String[] args) {
        SpringApplication.run(EntryPoint.class, args);
        System.out.printf("Application STARTED");  
    }
	
    @Scheduled(cron = "0 0 * * * ?") // Once an hour
    public void perform() throws Exception
    {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(job, params);
    }
}
