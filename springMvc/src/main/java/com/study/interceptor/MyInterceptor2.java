package com.study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//拦截器
public class MyInterceptor2 extends HandlerInterceptorAdapter{
	
	//Controller中功能处理方法之前调用
	//返回值: false-表示流程中断
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("MyInterceptor2 preHandle..");
		
		return true;
	}
	
	//Controller中功能处理方法之后调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("MyInterceptor2 postHandle..");
		
	}
	
	//视图渲染完毕之后调用
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor2 afterCompletion..");
	}
	
}
