package com.study.adapter;

public class MyAnnotationController {
	
	@MyTest("admin")
	public String test(){
		System.out.println("MyAnnotationController test..");
		
		return "test";
	}
	
}
