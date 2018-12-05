package servlet;
/*���������¼*/
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.cookUtils;

public class GetProductByIdServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		Cookie c = cookUtils.getCookieByname("ids", request.getCookies());
		
		String ids = "";
		if(c==null){
			//��cookieΪ�գ���Ҫ����ǰ��Ʒid����ids��
			ids=id;
			
		}else{
			//����Ϊ��
			//�ж�ids���Ƿ����id
			ids=c.getValue();
			String[] arr = ids.split("-");
			//������ת���ɼ��ϣ���list���Ȳ��ɱ�
			List<String> alist = Arrays.asList(arr);
			//��alist����һ����list��
			LinkedList<String> blist = new LinkedList<String>(alist);
			
			if(blist.contains(id)){
				//������  ��id��ɾ�� ���������ǰ��
				blist.remove(id);
				blist.addFirst(id);
				
			}else{
				//��������    �жϳ����Ƿ����2   ���3  
				//����   ���Ƴ����һλ
				//��id�������ǰ��
				if(blist.size()>2){
					blist.removeLast();
				}
				
				blist.addFirst(id);
			}
			
			ids="";
			for(String s:blist){
				ids+=(s+"-");
			}
			ids=ids.substring(0, ids.length()-1);
		}
		
		
		c=new Cookie("ids",ids);
		c.setMaxAge(3600);
		c.setPath(request.getContextPath()+"/");
		response.addCookie(c);
		
		
		response.sendRedirect(request.getContextPath()+"/product_info"+id+".htm");
	}

	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		doGet(request,response);
	}

}
