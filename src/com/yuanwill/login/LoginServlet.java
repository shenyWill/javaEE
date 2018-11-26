package com.yuanwill.login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.yuanwill.domain.User;
import com.yuanwill.utils.JDBCUtils;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 2.从数据库中验证是否正确
		QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from uses where username=? and password = ?";
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class), username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		// 3.返回的结果
		if (user != null) {
			response.getWriter().write(user.toString());
		}else {
			response.getWriter().write("login error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
