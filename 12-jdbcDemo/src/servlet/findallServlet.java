package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 展示所有商品
 * 
 * */



import domain.products;
import service.productService;

/*
 * 展示所有商品
 * 
 * */
public class findallServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html；charset=utf-8");
		//调用service 查询商品  返回list
		List<products> plist = null;
		try {
			plist = productService.findall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//将list放入request域中  
		request.setAttribute("products", plist);
	
		//请求转发
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
		
	}

}
