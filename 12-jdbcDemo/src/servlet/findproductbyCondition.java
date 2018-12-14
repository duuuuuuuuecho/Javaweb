package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.products;
import service.productService;

//多条件查询
public class findproductbyCondition extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1接收两个参数
		String name = request.getParameter("name");
		String key = request.getParameter("key");
		
		//2调用service查询
		List<products> plist = null;
		try {
			plist = productService.findproductbyCondition(name,key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3放入request域中，请求转发
		request.setAttribute("products", plist);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
