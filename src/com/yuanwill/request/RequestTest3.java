package com.yuanwill.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RequestTest3() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// request ת��
		RequestDispatcher dispatcher = request.getRequestDispatcher("/RequestTest4");
		request.setAttribute("name", "tom");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
