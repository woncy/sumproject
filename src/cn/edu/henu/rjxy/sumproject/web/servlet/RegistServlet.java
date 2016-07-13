package cn.edu.henu.rjxy.sumproject.web.servlet;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.henu.rjxy.sumproject.bean.User;

/**
 * 本类负责处理注册页面提供的数据
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  username = request.getParameter("username");
		String password = request.getParameter("password");
		String userId = UUID.randomUUID().toString();
		
		User user = new User();
		user.setUserId(userId);
		user.setUsername(username);
		user.setPassword(password);
	}

}
