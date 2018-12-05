package cookieServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 将访问时间记录,写会浏览器
 */
public class remberServlet extends HttpServlet {

	
	public remberServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置编码
		response.setContentType("text/html;charset=utf-8");
		//获取指定名称的cookie
		Cookie c = getCookieByname("lastTime",request.getCookies());
		
		//判断是否空
		if(c!=null){
			String s = c.getValue();
			long stime=Long.parseLong(s);
			Date date = new Date(stime);
			response.getWriter().print("上次访问的时间是："+date);
			
		}
		else{
			response.getWriter().print("这是第一次访问");
			
		}
		
		Cookie newc = new Cookie("lastTime",new Date().getTime()+"");
		//持久化
		newc.setMaxAge(3600);
		//设置路径
		newc.setPath(request.getContextPath());
		System.out.println(new Date().getTime());
		//将当前访问记录返回
		response.addCookie(newc);
		
	}

	
	private Cookie getCookieByname(String string, Cookie[] cookies) {
		// TODO Auto-generated method stub
		if(cookies!=null){
			for(Cookie c :cookies){
				if(string.equals(c.getName())){
					System.out.println("again");
					return c;
				}
			}
		}
		System.out.println("first");
		return null;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
