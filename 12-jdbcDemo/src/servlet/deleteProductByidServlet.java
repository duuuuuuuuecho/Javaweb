package servlet;

/*
 * 删除商品 通过id定位
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.productService;

public class deleteProductByidServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html,charset=utf-8");
		String pid = request.getParameter("pid");
		
		try {
			productService.deleteProductByid(pid);
			
			request.getRequestDispatcher("/findallServlet").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "删除失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return ;
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
