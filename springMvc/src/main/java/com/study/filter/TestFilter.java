package com.study.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(value="/*",initParams={@WebInitParam(name="name",value="zhangsan")},dispatcherTypes={DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE,DispatcherType.ERROR})
public class TestFilter implements Filter{

	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String name = filterConfig.getInitParameter("name");
		System.out.println("TestFilter.. init name = "+name);
	}
	
	//当过滤器拦截到一个请求的时候
	//会调用这个doFilter方法进行处理
	//FilterChain 过滤器链
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		System.out.println("TestFilter过滤器:servlet执行之前.. 拦截的路径:"+req.getServletPath());
		
		//使用过滤器链对象把请求和响应交给过滤器链中的下一个过滤器
		//如果过滤器链中没下一个过滤器了
		//就把请求和响应交给本次请求真正要访问的资源(例如一个servlet或者html页面)
		chain.doFilter(request, response);
		
//		System.out.println("TestFilter过滤器:servlet执行之后..");
		
	}

	@Override
	public void destroy() {
		System.out.println("TestFilter.. destroy");
	}

}
