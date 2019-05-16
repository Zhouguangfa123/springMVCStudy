package com.study.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/test")
	public String hello(Model model){
		
		System.out.println("HelloController hello..");
		
		model.addAttribute("name", "tom");
		
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2(){
		
		System.out.println("HelloController hello2..");
		
		ModelAndView mv = new ModelAndView("hello");
		
		mv.addObject("name", "tom");
		
		return mv;
	}
	
	//这时候,前端控制器会把映射路径"/hello3"当做路径视图名进行处理
	@RequestMapping("/hello3")
	public void hello3(){
		
		System.out.println("HelloController hello3..");
		
	}
	
	@RequestMapping("/hello4")
	public void hello4(HttpServletRequest request,HttpServletResponse response)throws Exception{
		System.out.println("HelloController hello4..");
		
		String path = "/WEB-INF/jsp/hello.jsp";
		request.setAttribute("name", "zhangsan");
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	@RequestMapping("/hello5")
	public void hello5(HttpServletRequest request,HttpServletResponse response)throws Exception{
		System.out.println("HelloController hello5..");
		
		String location = request.getContextPath()+"/hello4";
		response.sendRedirect(location);
	}
	
}
