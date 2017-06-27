package com.example.listener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;
/**
 * ApplicationFailedEvent:spring boot启动异常时执行事件 
 */
@Slf4j
public class MyApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent>{

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		System.out.println(getClass().getSimpleName());
		log.info("spring boot启动异常................");
		 Throwable throwable = event.getException();
	        handleThrowable(throwable);
		
	}
	/*处理异常*/
    private void handleThrowable(Throwable throwable) {
    	
    }
}
