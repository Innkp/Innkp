package com.innkp.Innkp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InnkpApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnkpApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		return (args) -> {
			System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作3<<<<<<<<<<<<<");
		};
	}
}
