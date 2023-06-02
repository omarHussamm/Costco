package com.example.Costco;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import util.LoggingFilter;

import java.util.Collections;

@EnableRabbit

@SpringBootApplication
public class OrderAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderAppApplication.class,args);
	}
	@Bean
	public FilterRegistrationBean<LoggingFilter> loggingFilterRegistrationBean() {
		FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new LoggingFilter());
		registrationBean.setUrlPatterns(Collections.singletonList("/*")); // Specify the URL patterns to intercept
		return registrationBean;
	}

}
