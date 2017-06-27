package com.example.bean;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置文件设置参数取值参考类
 * 
 *1. 在spring boot中是可以省去@value该注解,
 * 可以在需要获取配置文件中的参数值，使用@ConfigurationProperties,
 * 使用@ConfigurationProperties需要指定prefix,
 * 同时bean中的属性和配置参数名保持一致，
 * 如：user.address=china,shanghai
 * 
 *2.实体嵌套配置
 *
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix="user")
public class User {
	// :lkl不知道 什么 意思
	// @Value("${name:lkl}")
	@Value("${name}")
	private String name;
	@Value("${age}")
	private Integer age;
	@Value("${remark}")
	private String remark;
	
	private String address;
	
	private Address detailAddress;
	
	private List<Address> allAddress=new ArrayList<Address>();
}
