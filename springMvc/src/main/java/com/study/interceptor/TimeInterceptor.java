package com.study.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//拦截器
public class TimeInterceptor extends HandlerInterceptorAdapter{
	
	private ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
	
	//Controller中功能处理方法之前调用
	//返回值: false-表示流程中断
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		long start = System.currentTimeMillis();
		//每个线程使用的都是和自己绑定的threadLocal对象
		threadLocal.set(start);
		
		return true;
	}
	
	//Controller中功能处理方法之后调用
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long end = System.currentTimeMillis();
		//每个线程使用的都是和自己绑定的threadLocal对象
		Long start = threadLocal.get();
		
		System.out.println("本次请求共耗时:"+(end-start)+"毫秒");
		
	}
}
