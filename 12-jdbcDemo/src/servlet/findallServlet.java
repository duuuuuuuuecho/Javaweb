package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * չʾ������Ʒ
 * 
 * */



import domain.products;
import service.productService;

/*
 * չʾ������Ʒ
 * 
 * */
public class findallServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html��charset=utf-8");
		//����service ��ѯ��Ʒ  ����list
		List<products> plist = null;
		try {
			plist = productService.findall();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��list����request����  
		request.setAttribute("products", plist);
	
		//����ת��
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request,response);
		
	}

}
