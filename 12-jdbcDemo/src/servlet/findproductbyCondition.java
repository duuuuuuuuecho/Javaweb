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

//��������ѯ
public class findproductbyCondition extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1������������
		String name = request.getParameter("name");
		String key = request.getParameter("key");
		
		//2����service��ѯ
		List<products> plist = null;
		try {
			plist = productService.findproductbyCondition(name,key);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3����request���У�����ת��
		request.setAttribute("products", plist);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
