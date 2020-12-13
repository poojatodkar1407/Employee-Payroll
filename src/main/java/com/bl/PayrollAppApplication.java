package com.bl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
public class PayrollAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(PayrollAppApplication.class, args);
		System.out.println("Employee payroll"+applicationContext.getEnvironment().getProperty("enviornment"));
	}

}
