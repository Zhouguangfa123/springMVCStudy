package com.study.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * HelloWord
 *
 * @author zhougf
 * @date 2019/4/30
 */
public class HelloWord implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet..init..创建");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String name =servletRequest.getParameter("name");
        String id =servletRequest.getParameter("id");
        servletResponse.setContentType("text/html");
        PrintWriter out = servletResponse.getWriter();
        String str = "<h3>hello world test...</h3>"+name+id;
        out.println(str);
        out.flush();
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
        public void destroy() {
        System.out.println("servlet..destroy..销毁");
    }
}
