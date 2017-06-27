package com.example.listener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
/**
 * spring boot 启动监听类
 * ApplicationStartedEvent：spring boot启动开始时执行的事件
 */
@Slf4j
public class MyApplicationStartedEventlistener implements
		ApplicationListener<ApplicationStartedEvent> {
	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		System.out.println(getClass().getSimpleName());
		System.out.println("此监听log对象以创建，但日志信息不输出");
		log.info("MyApplicationStartedEventlistener  start..............................");
		SpringApplication app = event.getSpringApplication();
		/*
		 * Banner.Mode.OFF:关闭; 
		 * Banner.Mode.CONSOLE:控制台输出，默认方式;
		 * Banner.Mode.LOG:日志输出方式;
		 */
		app.setBannerMode(Banner.Mode.CONSOLE);
		log.info("MyApplicationStartedEventlistener......................................");

	}

}
