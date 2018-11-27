package com.yuanwill.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseTest4
 */
public class ResponseTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseTest4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置码表 -- 如果设置了客户端编码，则不需要写这句，会自动设置码表
//		response.setCharacterEncoding("UTF-8");
		
		// 设置客户端解码
//		response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8"); // 简写模式
		
		PrintWriter writer = response.getWriter();
		writer.write("hello 中国!!!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
