package com.innkp.Innkp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.innkp.Innkp.config.StorageProperties;
import com.innkp.Innkp.upload.StorageService;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(StorageProperties.class)
public class InnkpApplication {

	public static void main(String[] args) {
		SpringApplication.run(InnkpApplication.class, args);
	}

	// @Bean
	// CommandLineRunner init() {
	// return (args) -> {
	// System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作3<<<<<<<<<<<<<");
	// };
	// }
	// @Bean
	// public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	// return args -> {
	//
	// System.out.println("Let's inspect the beans provided by Spring Boot:");
	//
	// String[] beanNames = ctx.getBeanDefinitionNames();
	// Arrays.sort(beanNames);
	// for (String beanName : beanNames) {
	// System.out.println(beanName);
	// }
	//
	// };
	// }
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			// storageService.deleteAll();
			storageService.init();
		};
	}
}
