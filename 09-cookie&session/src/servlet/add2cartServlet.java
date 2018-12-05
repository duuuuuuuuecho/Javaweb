package servlet;
/*
 * 将商品添加入购物车
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
		//获取商品名称
		String name = request.getParameter("name");
		name=new String(name.getBytes("iso8859-1"),"utf-8");
		
		//获取session
//		String sessionid = request.getSession().getId();
//		System.out.print("id = "+sessionid);
		
		
		Map<String,Integer> carmap=(Map<String, Integer>) request.getSession().getAttribute("cart");
		
		
		Integer count=null;
		//判断是否空
		if(carmap==null){
			//为空    创建购物车
			System.out.println("cart 为空：：第一次创建session");
			carmap = new HashMap<String,Integer>();
			
			//将购物车放入session中
			request.getSession().setAttribute("cart", carmap);
			count=1;
		}else{
			System.out.print("cart 不为空");
			//不为空
			//判断商品是否存在   存在：数量+1  不存在：则添加
			count=carmap.get(name);
			if(count==null){
				System.out.print(name+":商品不存在");
				count=1;
			}else{
				System.out.print(name+":商品存在");
				count++;
				System.out.print("数量+1："+count);
			}
		}
		//添加商品
//		System.out.println("加入商品");
		carmap.put(name, count);
		
		Map<String,Integer> maps=(Map<String, Integer>) request.getSession().getAttribute("cart");
		System.out.println("session的大小:"+maps.size());
		
		
		//重定向
		response.getWriter().print("已经将<b>"+name+"</b>添加成功<hr>");
		response.getWriter().print("<a href='"+request.getContextPath()+"/product_list.jsp'>继续购物</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		response.getWriter().print("<a href='"+request.getContextPath()+"/cart.jsp'>查看购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
