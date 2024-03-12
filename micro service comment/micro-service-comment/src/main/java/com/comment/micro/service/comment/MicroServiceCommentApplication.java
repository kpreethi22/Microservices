package com.comment.micro.service.comment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceCommentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceCommentApplication.class, args);
	}

}
