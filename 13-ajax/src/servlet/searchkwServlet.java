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
		//1.��ȡkw
		String kw = request.getParameter("keyword");
		//2.����service���ģ������ ����ֵ:list
		List<Object> list = null ;
		try {
			list = userService.searchkw(kw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3.������  [a,aa,aaa] ȥ������ д��ȥ  a,aaa,aa
		if(list!=null && list.size()>0){
			String s = list.toString();
			s=s.substring(1, s.length()-1);
			System.out.println(s);
			response.getWriter().println(s);
		}
		
		
	}

}
