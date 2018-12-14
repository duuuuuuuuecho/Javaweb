package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import service.selectService;
import domain.city;

public class selectCityServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		String id  = request.getParameter("id");
		
		List<city> clist = null;
		try {
			clist = selectService.findallCity(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("³ÇÊÐ:"+clist);
		if(clist!=null &&clist.size()>0){
			System.out.println("·¢ËÍ");
			response.getWriter().print(JSONArray.fromObject(clist));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		
	}

}
