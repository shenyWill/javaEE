package com.yuanwill.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class MyFirstServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destroy running....");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		return null;
	}

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// 1.获取servlet的name
		String servletName = config.getServletName();
		// 2.获取servlet的param的值
		String servletParam = config.getInitParameter("url");
		// 3.获取servletcontext对象
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletName + "...." + servletParam + "..." + servletContext);
		System.out.println("init running...");
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 向客户端提供响应的方法
		HttpServletResponse response = (HttpServletResponse) res;
		response.getWriter().write("this is my first servlet!!");
		System.out.println("lalala");
	}

}
