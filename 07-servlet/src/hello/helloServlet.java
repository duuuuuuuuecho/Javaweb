package hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class helloServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("�������յ�");
		response.setContentType("text/html;charset=utf-8");   //��ֹ��������
		
		//��������
		String name = request.getParameter("username");
		System.out.println(name);
		
		//��������
		response.getWriter().println("����: "+name);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	public void init() throws ServletException {
		// Put your code here
	}
}
