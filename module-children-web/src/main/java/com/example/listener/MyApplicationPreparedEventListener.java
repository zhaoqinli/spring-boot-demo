package com.example.listener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * 上下文创建完成后执行的事件监听器
 * ApplicationPreparedEvent:spring boot上下文context创建完成，但此时spring中的bean是没有完全加载完成的
 */
@Slf4j
public class MyApplicationPreparedEventListener implements ApplicationListener<ApplicationPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		System.out.println(getClass().getSimpleName());
		log.info("上下文创建完成后执行的事件监听器................");
		ConfigurableApplicationContext cac = event.getApplicationContext();
        passContextInfo(cac);
		
	}
	 /**
     * 传递上下文
     * @param cac
     */
    private void passContextInfo(ApplicationContext cac) {
        //dosomething()
    }
}
