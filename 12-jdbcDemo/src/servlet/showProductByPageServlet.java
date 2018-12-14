package servlet;

/*分页展示数据*/
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.productService;
import domain.pageBean;
import domain.products;

public class showProductByPageServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		
		//1 获取第几页
		int currpage = Integer.parseInt(request.getParameter("currPage"));
		
		//设置每页显示的条数
		int pageSize = 3;
		
		//2调用service 完成分页查询  返回值 pagebeen
		pageBean<products> p = null;
		try {
			p = productService.showProductByPage(currpage,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3封装进request域 请求转发product_page.jsp
		request.setAttribute("PBean", p);
		request.getRequestDispatcher("/product_page.jsp").forward(request, response);;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
