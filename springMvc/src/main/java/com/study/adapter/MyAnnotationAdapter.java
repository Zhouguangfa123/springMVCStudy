package com.study.adapter;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

public class MyAnnotationAdapter implements HandlerAdapter{
	private Method m;
	@Override
	public boolean supports(Object handler) {
		
		Class<?> c = handler.getClass();
		
		Method[] methods = c.getMethods();
		for(Method m:methods){
			if(m.isAnnotationPresent(MyTest.class)){
				MyTest myTest = m.getAnnotation(MyTest.class);
				System.out.println(myTest.value());
				this.m = m;
				//.....
				return true;
			}
		}
		
		return false;
	}

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String viewName = (String) m.invoke(handler);
		
		return new ModelAndView(viewName);
	}

	@Override
	public long getLastModified(HttpServletRequest request, Object handler) {
		return 0;
	}

}
