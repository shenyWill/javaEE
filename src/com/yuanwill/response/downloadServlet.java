package com.yuanwill.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class downloadServlet
 */
public class downloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public downloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		
		// 解决中文文件名乱码报错
		filename = new String(filename.getBytes("ISO8859-1"),"utf-8");
		// 要下载的文件类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		
		// 告诉服务器不解析，直接下载
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		
		String realpath = getServletContext().getRealPath("/download/" + filename);
		// 获得该文件的输入流
		FileInputStream in = new FileInputStream(new File(realpath));
		int len = 0;
		byte[] buffer = new byte[1024];
		
		// 获得输出流
		ServletOutputStream out =  response.getOutputStream();
		while((len=in.read(buffer)) > 0) {
			out.write(buffer,0,len);
		}
		in.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
