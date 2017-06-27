package com.example.listener;

import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
/**
 * spring boot 配置环境事件监听
 * ApplicationEnvironmentPreparedEvent：spring boot 对应Enviroment已经准备完毕，但此时上下文context还没有创建
 */
@Slf4j
public class MyApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		System.out.println(getClass().getSimpleName());
		log.info("配置环境事件监听................");
		ConfigurableEnvironment envi=event.getEnvironment();
		MutablePropertySources mps=envi.getPropertySources();
		if(mps!=null){
			Iterator<PropertySource<?>> iter =mps.iterator();
			while(iter.hasNext()){
				PropertySource<?> ps=iter.next();
				log.info("ps.getName:{},ps.getSource:{},ps.getClass:{}.",ps.getName(),ps.getSource(),ps.getClass());
			}
		}
		
	}

}
