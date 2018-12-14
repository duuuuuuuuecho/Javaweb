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
 * ͨ��id��ѯ��Ʒ
 * */
public class findProductByidServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//��ȡid
		String pid = request.getParameter("pid");
		//��װ��ѯ������Ʒ
		products p = null;
		try {
			p = productService.findPorductByid(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "��ѯʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		//����request���� 
		request.setAttribute("f_product", p);
		//����ת����edit.jsp��
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
