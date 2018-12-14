package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.products;
import service.productService;

/*
 * 通过id查询商品
 * */
public class findProductByidServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//获取id
		String pid = request.getParameter("pid");
		//封装查询到的商品
		products p = null;
		try {
			p = productService.findPorductByid(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "查询失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		//放入request域中 
		request.setAttribute("f_product", p);
		//请求转发到edit.jsp中
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
