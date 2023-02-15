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
        
        /*
         Infos from CSV:
         id,first_name,last_name,email,
         supplier_pid,credit_card_number,credit_card_type,
         order_id,
         product_pid,
         shipping_address,
         country,
         date_created,quantity,
         full_name,order_status

         */
        
        //1 reads a csv 
        //2 parses the information into user and product object
        //3 for user objects, use the user service to save the data
        //4 for product objects, use the product service to save the data
        //5 for every row processed, write out the following values ( userPid , orderPid and supplierPid ) from the row to a new file called:  processed-orders.json
        System.out.printf("Running now");
        
        
        //for(;;) {
        //	AppContext.userClient().createUser(null, null, null, null);
        //}

        
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
