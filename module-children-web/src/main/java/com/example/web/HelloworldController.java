package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/springboot")
public class HelloworldController {
	@Autowired
	User user;
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public String sayWorld(@PathVariable("name")String name) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(user);
		System.out.println(json);
		return "Hello "+name;
	}
}
