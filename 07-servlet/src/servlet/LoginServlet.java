package servlet;

import java.io.IOException;
import java.sql.SQLException;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import domain.User;

public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	//��ʼ����¼����
	public void init() throws ServletException {
		//��ȡȫ�ֹ�����
		ServletContext context=  getServletContext();
		//��ʼ������     ��¼���ܴ���
		context.setAttribute("user_count", 0);
		
		System.out.println("��ʼ�������ɹ�");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");   //��ֹ��������
		//1.�����û��������� 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.����userservice  ���login(username,password) ����ֵ ��User user
		User user = null;
		try {
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("�����쳣");
		}
		
		//3.�ж�user�Ƿ�Ϊ��
		if(user == null){
			//������ 
			response.getWriter().print("�û������벻ƥ��,3�����ת");
			response.setHeader("refresh", "3;/07-servlet/login.htm");
			
		}else{
			//�ɹ�
			response.getWriter().println(user.getUid()+" ��ӭ����");
			response.getWriter().println(user.getUname()+" ����");
			response.getWriter().println(user.getUpassword()+" ����");
			response.getWriter().println(user.getTelphone()+" �绰");
			
			//��ȡȫ�ֹ�����
			ServletContext context = this.getServletContext();
			//��ȡ�ܴ��� ����+1
			int num = (int)context.getAttribute("user_count");
			num+=1;
			//����
			context.setAttribute("user_count", num);
		}
		
	}
}
