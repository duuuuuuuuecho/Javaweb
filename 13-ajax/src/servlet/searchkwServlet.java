package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.userService;

public class searchkwServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//1.获取kw
		String kw = request.getParameter("keyword");
		//2.调用service完成模糊操作 返回值:list
		List<Object> list = null ;
		try {
			list = userService.searchkw(kw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.将数据  [a,aa,aaa] 去掉括号 写回去  a,aaa,aa
		if(list!=null && list.size()>0){
			String s = list.toString();
			s=s.substring(1, s.length()-1);
			System.out.println(s);
			response.getWriter().println(s);
		}
		
		
	}

}
