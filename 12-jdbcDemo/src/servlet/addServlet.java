package servlet;
/*
 * 添加商品
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import service.productService;
import utils.UUidUtils;
import domain.products;

public class addServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1封装数据
		products p = new products();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			
			//0扩展    令牌机制    
			//0.1获取令牌
			String p_token = request.getParameter("token");
			String s_token = (String) request.getSession().getAttribute("codetoken");
			
			//0.2移除令牌
			request.getSession().removeAttribute("codetoken");
			
			//0.3对比令牌
			if(s_token==null ||! s_token.equals(p_token)){
				//已经提交过了
				request.setAttribute("msg", "重复提交");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
				return;
			}
			
			//1.1设置id   独一无二
			p.setPid(UUidUtils.getId());
			//1.2设置时间
			p.setPdate(new Date());
			
			//2调用service 
			productService.addProduct(p);
			
			//3页面跳转
			//方法一：请求转发    会重复提交     需要使用令牌机制
			request.getRequestDispatcher("/findallServlet").forward(request, response);
			
			//方法二：重定向
			//response.sendRedirect(request.getContextPath()+"/findallServlet");
			
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("msg", "添加商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		} 
		
		
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
