package com.example;


import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.listener.MyApplicationEnvironmentPreparedEventListener;
import com.example.listener.MyApplicationFailedEventListener;
import com.example.listener.MyApplicationPreparedEventListener;
import com.example.listener.MyApplicationStartedEventlistener;
@Slf4j
/*
 * spring boot设置多配置文件很简单，
 * 可以在bean上使用注解@Profile("development")即调用application-development.properties|yml文件,
 * 也可以调用SpringApplication中的etAdditionalProfiles()方法,
 * 也可以通过启动时,在application.properties中指定参数spring.profiles.active
 */
//@Profile("dev")
@Configuration//表示Application作为sprig配置文件存在 
@EnableAutoConfiguration//启动spring boot内置的自动配置 
//@ComponentScan：扫描bean，路径为Application类所在package以及package下的子路径，
//这里为 com.example，在spring boot中bean都放置在该路径已经子路径下。
@ComponentScan
public class Application {
	public static void main(String[] args) {
		//log.info("Application start begin........................");
		/*
		 *添加监听 
		 */
		SpringApplication app=new SpringApplication(Application.class);
		app.addListeners(new MyApplicationStartedEventlistener());
		app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
		app.addListeners(new MyApplicationPreparedEventListener());
		app.addListeners(new MyApplicationFailedEventListener());
		app.run(args);
//		ApplicationContext ctx=SpringApplication.run(Application.class, args);
//		String[] activeProfiles=ctx.getEnvironment().getActiveProfiles();
//		log.warn("Spring Boot 使用activeProfiles.length为:{}",activeProfiles.length);
//		for (String profile : activeProfiles) {
//			log.warn("Spring Boot 使用profile为:{}",profile);
//		}
		//log.info("Application start finish.....................");
	}
}
