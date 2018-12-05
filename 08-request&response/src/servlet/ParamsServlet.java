package servlet;
/*中文乱码处理*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ParamsServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name");
		System.out.println("name:"+name);
		
		String[] hobbys =request.getParameterValues("hobby");		
		for(String s:hobbys){
			System.out.println("hobby:"+s);
		}		
		
		Map<String,String[]> map = request.getParameterMap();
	    for(String key:map.keySet()){
	    	System.out.println(key+""+Arrays.toString(map.get(key)));
	    }
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//方法一  只能在post中用
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("username");
		//方法二：通用方法
		//name = new String(name.getBytes("iso8859-1"),"utf-8");
		String password = request.getParameter("password");
		System.out.println("name: "+name);
		System.out.println("password: "+password);
		
	
		
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
