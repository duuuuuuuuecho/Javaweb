package servlet;
/*增加浏览记录*/
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
			//若cookie为空，需要将当前商品id放入ids中
			ids=id;
			
		}else{
			//若不为空
			//判断ids中是否包含id
			ids=c.getValue();
			String[] arr = ids.split("-");
			//将数组转换成集合，此list长度不可变
			List<String> alist = Arrays.asList(arr);
			//将alist放入一个新list中
			LinkedList<String> blist = new LinkedList<String>(alist);
			
			if(blist.contains(id)){
				//若包含  则将id先删除 在添加在最前面
				blist.remove(id);
				blist.addFirst(id);
				
			}else{
				//若不包含    判断长度是否大于2   最大3  
				//大于   则移除最后一位
				//将id添加在最前面
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
