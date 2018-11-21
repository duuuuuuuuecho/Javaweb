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
	//初始化登录次数
	public void init() throws ServletException {
		//获取全局管理者
		ServletContext context=  getServletContext();
		//初始化次数     登录的总次数
		context.setAttribute("user_count", 0);
		
		System.out.println("初始化次数成功");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");   //防止中文乱码
		//1.接受用户名与密码 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.调用userservice  里的login(username,password) 返回值 ：User user
		User user = null;
		try {
			user = new UserService().login(username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("网络异常");
		}
		
		//3.判断user是否为空
		if(user == null){
			//不存在 
			response.getWriter().print("用户名密码不匹配,3秒后跳转");
			response.setHeader("refresh", "3;/07-servlet/login.htm");
			
		}else{
			//成功
			response.getWriter().println(user.getUid()+" 欢迎回来");
			response.getWriter().println(user.getUname()+" 名字");
			response.getWriter().println(user.getUpassword()+" 密码");
			response.getWriter().println(user.getTelphone()+" 电话");
			
			//获取全局管理者
			ServletContext context = this.getServletContext();
			//获取总次数 次数+1
			int num = (int)context.getAttribute("user_count");
			num+=1;
			//保存
			context.setAttribute("user_count", num);
		}
		
	}
}
