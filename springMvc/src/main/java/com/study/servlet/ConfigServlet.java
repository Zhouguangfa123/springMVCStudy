package com.study.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;


@WebServlet(value="/config",initParams={@WebInitParam(name="name",value="zhangsan"),@WebInitParam(name="age",value="20")})
@SuppressWarnings("all")
public class ConfigServlet implements Servlet{
	
	private transient ServletConfig config;
	
	//servlet对象被创建的时候会调用init方法做初始化
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		
		System.out.println(config.getServletName());
		System.out.println("--------------");
		System.out.println(config.getInitParameter("name"));
		System.out.println(config.getInitParameter("age"));
		System.out.println("----------------");
		
		Enumeration<String> names = config.getInitParameterNames();
		
		while(names.hasMoreElements()){
			
			String paramName = names.nextElement();
			System.out.println(paramName+" = "+config.getInitParameter(paramName));
			
		}
	}

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}
	
	//接收浏览器的请求request
	//设置给浏览器的响应内容response
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
	}
	
	
	//返回servlet的相关信息(可选)
	@Override
	public String getServletInfo() {
		return "";
	}
	
	//servlet被销毁之前会调用destroy方法
	@Override
	public void destroy() {
		
		
	}
	
}
