package com.innkp.Innkp.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	// public static String LOGIN_USER = "loginUser";
	//
	// @Override
	// public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addViewController("/").setViewName("forward:/index");
	// registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	// super.addViewControllers(registry);
	// }

/*	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// registry.addResourceHandler("/**").addResourceLocations("file:D:/MyWork/Server/Innkp2/upload-dir/");
		// registry.addResourceHandler("/**").addResourceLocations("file:///home/ubuntu/projects/innkp_test/upload-dir/");
		// registry.addResourceHandler("/**").addResourceLocations("classpath:../upload-dir/");
		// 将所有/static/** 访问都映射到classpath:/static/ 目录下
//		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/../../../upload/");
		registry.addResourceHandler("/**").addResourceLocations("file:D:/WORK/Server/Innkp/upload");
		super.addResourceHandlers(registry);
	}*/

	@Bean
	public HttpMessageConverter<String> responseBodyConverter() {
		StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		return converter;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		converters.add(responseBodyConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false);
	}

}