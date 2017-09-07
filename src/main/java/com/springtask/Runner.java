package com.springtask;

import com.springtask.content.StaticContent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Runner {

	public static void main(String[] args) throws Exception {

		StaticContent.setStartTimeOfApp(System.currentTimeMillis());

		SpringApplication.run(Runner.class, args);

	}


}
