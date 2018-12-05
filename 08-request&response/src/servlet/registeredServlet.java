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
 * 用户注册
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
	    //设置编码
		request.setCharacterEncoding("utf-8");
		
		//封装数据  使用beanutils封装
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
			request.setAttribute("msg","添加成功");
			
			
			request.getRequestDispatcher("/msgServlet").forward(request,response);
		}else{
			request.setAttribute("msg","添加失败");
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
				System.out.println("注册成功");
			}else{
				System.out.println("失败");
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
