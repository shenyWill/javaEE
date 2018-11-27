package com.yuanwill.response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

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
		
		// ��������ļ������뱨��
		filename = new String(filename.getBytes("ISO8859-1"),"utf-8");
		
		// �������ͷ�е�user-agent
		String agent = request.getHeader("User-Agent");
		
		//���ݲ�ͬ��������в�ͬ�ı���
		String filenameEncoder = "";
		if (agent.contains("MSIE")) {
			// IE�����
			filenameEncoder = URLEncoder.encode(filename, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
		} else if (agent.contains("Firefox")) {
			// ��������
			BASE64Encoder base64Encoder = new BASE64Encoder();
			filenameEncoder = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
		} else {
			// ���������
			filenameEncoder = URLEncoder.encode(filename, "utf-8");				
		}
		
		// Ҫ���ص��ļ�����
		response.setContentType(this.getServletContext().getMimeType(filename));
		
		// ���߷�������������ֱ������
		response.setHeader("Content-Disposition", "attachment;filename=" + filenameEncoder);
		
		String realpath = getServletContext().getRealPath("/download/" + filename);
		// ��ø��ļ���������
		FileInputStream in = new FileInputStream(new File(realpath));
		int len = 0;
		byte[] buffer = new byte[1024];
		
		// ��������
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
