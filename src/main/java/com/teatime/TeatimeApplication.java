package com.teatime;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TeatimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeatimeApplication.class, args);
	}

}