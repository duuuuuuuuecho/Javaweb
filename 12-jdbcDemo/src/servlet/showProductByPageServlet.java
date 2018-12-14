package servlet;

/*��ҳչʾ����*/
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
		
		//1 ��ȡ�ڼ�ҳ
		int currpage = Integer.parseInt(request.getParameter("currPage"));
		
		//����ÿҳ��ʾ������
		int pageSize = 3;
		
		//2����service ��ɷ�ҳ��ѯ  ����ֵ pagebeen
		pageBean<products> p = null;
		try {
			p = productService.showProductByPage(currpage,pageSize);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3��װ��request�� ����ת��product_page.jsp
		request.setAttribute("PBean", p);
		request.getRequestDispatcher("/product_page.jsp").forward(request, response);;
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
