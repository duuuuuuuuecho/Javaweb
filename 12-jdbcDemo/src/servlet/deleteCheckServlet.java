package servlet;
/*
 * ɾ��ѡ�е���Ʒ
 * ����ɾ��
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
		
		//��ȡid
		String[] ids = request.getParameterValues("pid");
		
		//����serviceɾ�����
		try {
			productService.deleteManyProducts(ids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "ɾ�����ʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return ;
		}
		
		//�ض���
		response.sendRedirect(request.getContextPath()+"/findallServlet");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
