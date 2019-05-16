package com.study.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/life")
public class LifeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	public LifeServlet() {
		System.out.println("LifeServlet.. ������");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeServlet.. init");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeServlet.. doGet");
	}
	
	@Override
	public void destroy() {
		System.out.println("LifeServlet.. destroy");
	}
	
}
