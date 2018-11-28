package com.yuanwill.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class requestTest1
 */
public class requestTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求方式
		String method = request.getMethod();
		
		// 获取请求我的资源相关内容
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		
		// 获得web应用名称
		String contextpath = request.getContextPath();
		
		// 地址后的参数的字符串
		String queryString = request.getQueryString();
		
		System.out.println(
				"method:" + method + "\n" + 
				"requestURI:" + requestURI + "\n" + 
				"requestURL:" + requestURL + "\n" + 
				"contextpath:" + contextpath + "\n" +
				"queryString:" + queryString
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
