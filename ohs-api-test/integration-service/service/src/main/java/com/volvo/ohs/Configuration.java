package com.volvo.ohs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileSystemResource;

import com.volvo.ohs.csv.DebugWriter;
import com.volvo.ohs.csv.GrpcEntitiesWriter;
import com.volvo.ohs.csv.SingleRowDto;

@org.springframework.context.annotation.Configuration
@EnableBatchProcessing
public class Configuration {

	private static final String ORDER_INTEGRATION_FILE = "order-integration.csv";

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job readCSVFilesJob() {
		return jobBuilderFactory
				.get("readCSVFilesJob")
				.incrementer(new RunIdIncrementer())
				.start(step1())
				.build();
	}

	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<SingleRowDto, SingleRowDto>chunk(5)
				.reader(orderIntegrationReader())
				.writer(grpcWriter()).build();
	}

	@Bean
	public DebugWriter<SingleRowDto> writer() {
		return new DebugWriter<SingleRowDto>();
	}

	@Bean
	public GrpcEntitiesWriter<SingleRowDto> grpcWriter() {
		return new GrpcEntitiesWriter<SingleRowDto>();
	}
	@Bean
	public FlatFileItemReader<SingleRowDto> orderIntegrationReader() {
		FlatFileItemReader<SingleRowDto> reader = new FlatFileItemReader<SingleRowDto>();
		reader.setResource(new FileSystemResource(ORDER_INTEGRATION_FILE));

		// Skip Header
		reader.setLinesToSkip(1);
		reader.setLineMapper(new DefaultLineMapper<SingleRowDto>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames(new String[] { "id", 
								"first_name", 
								"last_name", 
								"email", 
								"supplier_pid", 
								"credit_card_number", 
								"credit_card_type", 
								"order_id", 
								"product_pid", 
								"shipping_address", 
								"country", 
								"date_created", 
								"quantity", 
								"full_name", 
								"order_status" });
					}
				});

				setFieldSetMapper(new BeanWrapperFieldSetMapper<SingleRowDto>() {
					{
						setTargetType(SingleRowDto.class);
					}
				});
			}
		});
		return reader;
	}
}
