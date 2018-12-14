package servlet;
/*转账操作 
 * Auser ->  Buser
 * 
 * */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.accountService;

public class accountServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String Auser = request.getParameter("Auser");
		String Buser = request.getParameter("Buser");
		String money = request.getParameter("money");
		
		
		try {
			//accountService.tranfer0(Auser,Buser,money);
			//accountService.tranfer1(Auser,Buser,money);
			//accountService.tranfer2(Auser,Buser,money);
			accountService.tranfer3(Auser,Buser,money);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print("转账失败");
			return;
		}
		out.print("转账成功");
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
		
	}

}
