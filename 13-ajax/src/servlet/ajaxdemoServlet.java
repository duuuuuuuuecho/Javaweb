package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ajaxdemoServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String succ = "����ʽ��"+request.getMethod();
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		name = new String(name.getBytes("ISO-8859-1"),"utf-8");
		System.out.print(name);
		response.getWriter().print(succ);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.print("����ʽ��"+request.getMethod());
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		System.out.print(name);
		
		//{"result":"success","msg":"�ɹ�"}
		String succ ="{\"result\":\"success\",\"msg\":\"�ɹ�\"}";
		response.getWriter().print(succ);
		
	}

}
