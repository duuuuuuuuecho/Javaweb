package servlet;
/*
 * �����Ʒ
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
		
		//1��װ����
		products p = new products();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			
			//0��չ    ���ƻ���    
			//0.1��ȡ����
			String p_token = request.getParameter("token");
			String s_token = (String) request.getSession().getAttribute("codetoken");
			
			//0.2�Ƴ�����
			request.getSession().removeAttribute("codetoken");
			
			//0.3�Ա�����
			if(s_token==null ||! s_token.equals(p_token)){
				//�Ѿ��ύ����
				request.setAttribute("msg", "�ظ��ύ");
				request.getRequestDispatcher("/msg.jsp").forward(request, response);
				return;
			}
			
			//1.1����id   ��һ�޶�
			p.setPid(UUidUtils.getId());
			//1.2����ʱ��
			p.setPdate(new Date());
			
			//2����service 
			productService.addProduct(p);
			
			//3ҳ����ת
			//����һ������ת��    ���ظ��ύ     ��Ҫʹ�����ƻ���
			request.getRequestDispatcher("/findallServlet").forward(request, response);
			
			//���������ض���
			//response.sendRedirect(request.getContextPath()+"/findallServlet");
			
			
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			request.setAttribute("msg", "�����Ʒʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			
		} 
		
		
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
