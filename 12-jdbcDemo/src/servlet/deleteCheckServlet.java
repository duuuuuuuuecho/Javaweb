package servlet;
/*
 * 删除选中的商品
 * 多行删除
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.productService;

public class deleteCheckServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取id
		String[] ids = request.getParameterValues("pid");
		
		//调用service删除多个
		try {
			productService.deleteManyProducts(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "删除多个失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return ;
		}
		
		//重定向
		response.sendRedirect(request.getContextPath()+"/findallServlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
