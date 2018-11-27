package com.yuanwill.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ResponseTest1() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 手动设置response状态码
		response.setStatus(302);
		
		// 设置响应头
		response.setHeader("name", "yuanwill");
		response.setDateHeader("birthday", new Date().getTime());
		response.setIntHeader("age", 18);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
