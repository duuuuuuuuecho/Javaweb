package servlet;
/*
 * ����Ʒ����빺�ﳵ
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class add2cartServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		//��ȡ��Ʒ����
		String name = request.getParameter("name");
		name=new String(name.getBytes("iso8859-1"),"utf-8");
		
		//��ȡsession
//		String sessionid = request.getSession().getId();
//		System.out.print("id = "+sessionid);
		
		
		Map<String,Integer> carmap=(Map<String, Integer>) request.getSession().getAttribute("cart");
		
		
		Integer count=null;
		//�ж��Ƿ��
		if(carmap==null){
			//Ϊ��    �������ﳵ
			System.out.println("cart Ϊ�գ�����һ�δ���session");
			carmap = new HashMap<String,Integer>();
			
			//�����ﳵ����session��
			request.getSession().setAttribute("cart", carmap);
			count=1;
		}else{
			System.out.print("cart ��Ϊ��");
			//��Ϊ��
			//�ж���Ʒ�Ƿ����   ���ڣ�����+1  �����ڣ������
			count=carmap.get(name);
			if(count==null){
				System.out.print(name+":��Ʒ������");
				count=1;
			}else{
				System.out.print(name+":��Ʒ����");
				count++;
				System.out.print("����+1��"+count);
			}
		}
		//�����Ʒ
//		System.out.println("������Ʒ");
		carmap.put(name, count);
		
		Map<String,Integer> maps=(Map<String, Integer>) request.getSession().getAttribute("cart");
		System.out.println("session�Ĵ�С:"+maps.size());
		
		
		//�ض���
		response.getWriter().print("�Ѿ���<b>"+name+"</b>��ӳɹ�<hr>");
		response.getWriter().print("<a href='"+request.getContextPath()+"/product_list.jsp'>��������</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		response.getWriter().print("<a href='"+request.getContextPath()+"/cart.jsp'>�鿴���ﳵ</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
