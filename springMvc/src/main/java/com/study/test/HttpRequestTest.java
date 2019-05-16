package com.study.test;

import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

public class HttpRequestTest {
	
	public static void main(String[] args) {
		
		
		try {
			String url = "http://localhost:8080/springMvc/request_header/test8";
			
			//创建HttpRequest
			ClientHttpRequest request =
			new SimpleClientHttpRequestFactory().
			createRequest(new URI(url), HttpMethod.POST);
			
			
			//设置请求头的内容类型头和内容编码
//			request.getHeaders().set("Content-Type", "application/json;charset=UTF-8");
			request.getHeaders().set("Accept", "application/json");
			
			//写出请求内容体
			String jsonData = "{\"username\":\"zhang\", \"password\":\"123\"}";
			request.getBody().write(jsonData.getBytes("UTF-8"));
			
			//发送请求并得到响应
			ClientHttpResponse response = request.execute();
			System.out.println(response.getStatusCode());
			System.out.println(response.getHeaders());
			
			System.out.println("-------------------");
			
			
			Charset charset = response.getHeaders().getContentType().getCharSet();
			int len = (int)response.getHeaders().getContentLength();
			//得到响应体的内容
			InputStream is = response.getBody();
			byte bytes[] = new byte[len];
			
			is.read(bytes);
			String data = new String(bytes, charset);
			System.out.println("charset="+charset);
			System.out.println("data : " + data);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
