package com.post.micro.service.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServicePostApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicePostApplication.class, args);
	}

}
