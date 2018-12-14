package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.productService;
import domain.products;

/*
 * 修改商品
 * */
public class editServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1封装数据
		products p = new products();
		
		try {
			BeanUtils.populate(p, request.getParameterMap());
			
			//2调用service 
			productService.updateProduct(p);
			
			//3重定向
			response.sendRedirect(request.getContextPath()+"/findallServlet");
			
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			request.setAttribute("msg", "更新失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
