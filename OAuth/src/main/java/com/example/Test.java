package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {

	
	@RequestMapping("/hello")
	public String  choose()
	{
		return "hello srikanth";
	}
}
