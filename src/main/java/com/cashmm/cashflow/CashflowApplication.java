package com.cashmm.cashflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.cashmm.cashflow")
public class CashflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(CashflowApplication.class, args);
	}

}
