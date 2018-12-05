package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import damain.User;
import service.registeredService;



/*
 * �û�ע��
 * */
public class registeredServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public registeredServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    //���ñ���
		request.setCharacterEncoding("utf-8");
		
		//��װ����  ʹ��beanutils��װ
		User user=new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
//			System.out.println(user.getUname());
//			System.out.println(user.getUpassword());
//			System.out.println(user.getTelphone());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int i = 0;
		try {
			i = registeredService.registerUser(user);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(i);
		if(i==1){
			request.setAttribute("msg","��ӳɹ�");
			
			
			request.getRequestDispatcher("/msgServlet").forward(request,response);
		}else{
			request.setAttribute("msg","���ʧ��");
			request.getRequestDispatcher("/msgServlet").forward(request,response);
		}
		
		
		
		/*
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String telphone = request.getParameter("telphone");
		int line = 0;
		try {
			line = registeredService.registerUser(username,password,telphone);
			if(line>0){
				System.out.println("ע��ɹ�");
			}else{
				System.out.println("ʧ��");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	public void init() throws ServletException {
		// Put your code here
	}

}
