package com.study.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.bean.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@RequestMapping("/args")
@Controller
public class ArgsController {
	
	/*
	 * Controller中功能处理方法的参数列表 
	 */
	
	
	@RequestMapping("/test1")
	public String test1(HttpServletRequest request,HttpServletResponse response)throws Exception{
		System.out.println("ArgsController test1..");
		
		System.out.println("request = "+request);
		System.out.println("response = "+response);
		
		return "test";
	}
	
	
	@RequestMapping("/test2")
	public void test2(InputStream in,OutputStream out)throws Exception{
		System.out.println("ArgsController test2..");
		
		System.out.println("in = "+in);
		System.out.println("out = "+out);
		
		out.write("hello".getBytes("UTF-8"));
		out.flush();
	}
	
	@RequestMapping("/test3")
	public void test3(Reader in,Writer out)throws Exception{
		System.out.println("ArgsController test3..");
		
		System.out.println("in = "+in);
		System.out.println("out = "+out);
		
		out.write("hello world");
		out.flush();
	}
	
	
	@RequestMapping("/test4")
	public String test4(WebRequest webRequest,NativeWebRequest nativeWebRequest)throws Exception{
		System.out.println("ArgsController test4..");
		
		webRequest.setAttribute("name", "tom", WebRequest.SCOPE_REQUEST);
		
		Object value = webRequest.getAttribute("name", WebRequest.SCOPE_REQUEST);
		System.out.println(value);
		
		System.out.println("--------------------");
		
		HttpServletRequest request = 
				nativeWebRequest.getNativeRequest(HttpServletRequest.class);
		HttpServletResponse response = 
				nativeWebRequest.getNativeResponse(HttpServletResponse.class);
		
		System.out.println("request = "+request);
		System.out.println("response = "+response);
		
		return "test";
		
	}
	
	
	@RequestMapping("/test5")
	public String test5(HttpSession session)throws Exception{
		System.out.println("ArgsController test5..");
		
		System.out.println("sessionid = "+session.getId());
		
		return "test";
		
	}
	
	@RequestMapping("/test6")
	public String test6(User u)throws Exception{
		System.out.println("ArgsController test6..");
		
		System.out.println("u = "+u);
		
		return "test";
		
	}

	
	@RequestMapping("/test7")
	public String test7(Model m1, Map<String,Object> m2, ModelMap m3)throws Exception{
		System.out.println("ArgsController test7..");
		
		m1.addAttribute("a", "a");  
		m2.put("b", "b");  
		m3.put("c", "c");  
		System.out.println(m1 == m2);  
		System.out.println(m1 == m3);  
		System.out.println(m1.getClass());
		System.out.println(m2.getClass());
		System.out.println(m3.getClass());
		
		return "test";
		
	}
	
	
	
	//HttpEntity表示客户端接收的请求
	//使用这个类型可以很方法拿到请求中的各部分信息
	@RequestMapping("/test8")
	public String test8(HttpEntity<String> httpEntity)throws Exception{
		System.out.println("ArgsController test8..");
		
		//获得请求中的所有的header部分
		HttpHeaders headers = httpEntity.getHeaders();
		
		//获得请求中的所有的body部分
		String body = httpEntity.getBody();  
		
		Set<Entry<String,List<String>>> set = headers.entrySet();
		
		StringBuffer s = new StringBuffer();
		for(Entry<String,List<String>> entry:set){
			String key = entry.getKey();
			s.append(key+": ");
			List<String> list = entry.getValue();
			for(String value:list){
				s.append(value+" ");
			}
			System.out.println(s.toString());
			
			s.setLength(0);
		}
		System.out.println("----------------");
		System.out.println("body = "+body);
		
		
		return "test";
		
	}
	
	
	//ResponseEntity类型表示要给客户端返回的响应
	//使用这个类型很可以轻松的设置响应各个部分
	@RequestMapping("/test9")
	public ResponseEntity<String> test9()throws Exception{
		System.out.println("ArgsController test9..");
		
		//创建响应头对象
		HttpHeaders headers = new HttpHeaders();
		
		//response.setContentType("text/html;charset=utf-8")
		//创建MediaType对象
		MediaType mt = new MediaType("text","html",Charset.forName("UTF-8")); 
		//设置ContentType
		headers.setContentType(mt);  

		//准备好相应体
		String content = new String("hello world");

		//根据 响应内容/响应头信息/响应状态码 创建响应对象
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(content,headers,HttpStatus.OK);
		
		return responseEntity;
		
	}
	
	
	
	//使用这个类型,可以情况session中的特定对象
	@RequestMapping("/test10")
	public String test10(SessionStatus status)throws Exception{
		System.out.println("ArgsController test10..");
		
		System.out.println("status = "+status);
		
		return "test";
		
	}
	
	
	@RequestMapping("/test11")
	public String test11()throws Exception{
		System.out.println("ArgsController test11..");
		
		return "success";
		
	}
	
	
	//RedirectAttributes
	//使用场合
	//1.重定向的时候
	//2.在页面中显示的值只能生效一次
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(User u, RedirectAttributes redirectAttributes){
		
		System.out.println("ArgsController register..");
		System.out.println("u = "+u);
//		request.setAttribute("msg", u.getName()+"注册成功");
		redirectAttributes.addFlashAttribute("msg", u.getName()+"注册成功");
		
		
		return "redirect:/args/test11";
	}
	
	
	
	//BindingResult要结合后面学习的数据验证功能来测试
	//BindingResult类型中可以保存数据验证不通过时候的错误信息
	@RequestMapping("/test12")
	public String test12(BindingResult bindingResult)throws Exception{
		System.out.println("ArgsController test12..");
		
		System.out.println("bindingResult = "+bindingResult);
		
		return "test";
		
	}
	
}
