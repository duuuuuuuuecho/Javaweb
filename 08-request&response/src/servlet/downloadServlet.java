package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class downloadServlet extends HttpServlet {

	/**
	 * �ļ�����
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public downloadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html;charset=utf-8");
		String filename= request.getParameter("name");
		//��������
		filename = new String(filename.getBytes("iso8859-1"),"utf-8");
		System.out.println(filename);
		
		ServletContext context = this.getServletContext();
		
		//��ȡ�ļ�mime����
		String mimetype = context.getMimeType(filename);
		
		//�����ļ���mime����
		response.setContentType(mimetype);
		
		//������������Ϣ
		String newfile = new String(filename.getBytes("gbk"),"iso8859-1");
		response.setHeader("content-disposition", "attchment;filename="+newfile);
		
		//��ȡ�ļ���
		InputStream in = context.getResourceAsStream("/download/"+filename);
		ServletOutputStream out = response.getOutputStream();
		
		int len = -1;
		byte[] by = new byte[1024];
		
		while((len=in.read(by))!=-1){
			out.write(by, 0, len);
			
		}
		out.close();
		in.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
