package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import service.userService;
import constant.constant;
public class loginServlet extends HttpServlet {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String uname=request.getParameter("username");
		String upassword= request.getParameter("password");
		
		User user = null;
		try {
			user = userService.login(uname,upassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(user==null){
			request.setAttribute("msg", "�û������벻ƥ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}else{
			//��Ϊ��  ��ת��loginSuccess
			request.getSession().setAttribute("user", user);
			//�ж��Ƿ�ѡ���Զ���¼ д�������
			if(constant.IS_AUTO_LOGIN.equals(request.getParameter("autologin"))){
				//д��cookie
				Cookie c = new Cookie("autologin",URLEncoder.encode(uname+"-"+upassword,"utf-8"));
				c.setMaxAge(3600);
				c.setPath(request.getContextPath()+"/");
				response.addCookie(c);
			}
			//�ж��Ƿ�ѡ�˼�ס�û��� д�������
			if(constant.IS_SAVE_NAME.equals(request.getParameter("savename"))){
				//д��cookie
				Cookie c = new Cookie("autoname",URLEncoder.encode(uname,"utf-8"));
				c.setMaxAge(3600);
				c.setPath(request.getContextPath()+"/");
				response.addCookie(c);
				
			}
			
			
			//request.getRequestDispatcher("/loginSuccess.jsp").forward(request, response);	
		    response.sendRedirect(request.getContextPath()+"/loginSuccess.jsp");
		}
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
		
	}

}
