package com.study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/test2")
public class Test2Servlet extends GenericServlet{
	private static final long serialVersionUID = 1L;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		System.out.println("Test2Servlet.. service");
		
		res.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = res.getWriter();
		out.println("<html>");
			out.println("<head></head>");
			out.println("<body><h1>hello world11</h1></body>");
		out.println("</html>");
		
		out.flush();
		
	}
	
	
	
}
