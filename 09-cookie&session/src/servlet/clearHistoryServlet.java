package servlet;
/*½«ä¯ÀÀ¼ÇÂ¼Çå¿Õ*/


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.cookUtils;

public class clearHistoryServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		Cookie c =new Cookie("ids",""); 
		c.setMaxAge(0);
		c.setPath(request.getContextPath()+"/");
		response.addCookie(c);
		
		response.sendRedirect(request.getContextPath()+"/product_list.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
