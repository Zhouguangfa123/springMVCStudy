package com.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commom.ProPerTiesTools;
import com.commom.TokenTools;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello(Model model, HttpServletRequest request) throws Exception {
		Map<String, String> params = new HashMap<String, String>(8);
		Properties properties = ProPerTiesTools.getProperties("F:/gs/springMvc/src/main/resources/user.properties");
		params.put("userName", properties.getProperty("userName"));
		System.out.println(params.get("userName"));
		params.put("userName","z");
		String token = TokenTools.getToken(request,"X-Token",params);
		System.out.println("HelloController hello..");
		model.addAttribute("name", token);
		
		return "hello";
	}
	
	@RequestMapping("/hello2")
	public ModelAndView hello2(HttpServletRequest request){
		System.out.println("HelloController hello2..");
		ModelAndView mv = new ModelAndView("hello");
		TokenTools.judgeTokenIsEqual(request,"X-Token","X-Token");


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
