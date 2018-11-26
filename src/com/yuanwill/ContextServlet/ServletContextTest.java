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
		
		// 获取A.txt
				String realPath_A = context.getRealPath("/WEB-INF/a.txt");
				System.out.println(realPath_A);
		
		// 获取b.txt
		String realPath_B = context.getRealPath("/b.txt");
		System.out.println(realPath_B);
		
		// 获取 c.txt
		String realPath_C = context.getRealPath("/WEB-INF/classes/c.txt");
		System.out.println(realPath_C);
		
		// 获取不到d.txt
		
		// 在读取src(classes)下的资源是可以同类加载器--专门加载classes下的文件
		// 地址相当于classes
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
