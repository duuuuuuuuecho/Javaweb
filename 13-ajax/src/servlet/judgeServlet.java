package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user;
import service.userService;
/*
 * 判断用户是否存在
 * */
public class judgeServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		username= new String(username.getBytes("iso-8859-1"),"utf-8");
		
		user u = null;
		try {
			u = userService.judge(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(u != null){
			//用户名已存在
			response.getWriter().print("1");
			
		}else{
			//用户名不存在
			response.getWriter().print("0");
			
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	
	}

}
