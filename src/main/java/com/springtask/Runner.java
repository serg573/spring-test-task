package com.springtask;

import com.springtask.content.StaticContent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;

@SpringBootApplication
@EnableScheduling
public class Runner {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(Runner.class, args);

		StaticContent.setStartTimeOfApp(System.currentTimeMillis());

		SpringApplication.run(Runner.class);

	}


}
