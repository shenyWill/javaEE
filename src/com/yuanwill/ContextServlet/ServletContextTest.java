package com.yuanwill.ContextServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTest
 */
public class ServletContextTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String initParam = context.getInitParameter("name");
		System.out.println(initParam);
		
		// ��ȡA.txt
				String realPath_A = context.getRealPath("/WEB-INF/a.txt");
				System.out.println(realPath_A);
		
		// ��ȡb.txt
		String realPath_B = context.getRealPath("/b.txt");
		System.out.println(realPath_B);
		
		// ��ȡ c.txt
		String realPath_C = context.getRealPath("/WEB-INF/classes/c.txt");
		System.out.println(realPath_C);
		
		// ��ȡ����d.txt
		
		// �ڶ�ȡsrc(classes)�µ���Դ�ǿ���ͬ�������--ר�ż���classes�µ��ļ�
		// ��ַ�൱��classes
		String path = ServletContextTest.class.getClassLoader().getResource("c.txt").getPath();
		System.out.println(path);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
