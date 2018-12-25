package filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.userService;
import utils.cookUtils;
import domain.User;

public class autoFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	//�Զ���¼
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//1ǿת
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//2�Զ���¼
		//2.1�ж�session����û�е�¼�û�  û�еĻ�=�Զ���¼
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			//userΪ��  ��Ҫ�Զ���¼
			//2.2 �жϷ��ʵ���Դ�Ƿ�͵�¼ע����أ������ = ��Ҫ�Զ���¼
			String path=request.getRequestURI();
			if(!path.contains("login")){
				//2.3��ȡָ��cookie
				Cookie c=cookUtils.getCookieByname("autologin", request.getCookies());
				
				if(c!=null){
					//��Ϊ��
					String name = c.getValue().split("-")[0];
					String password = c.getValue().split("-")[1];
				
					try {
						user = userService.login(name,password);
				
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(user!=null){
						request.getSession().setAttribute("user", user);	
					}
				}
				
				
			}
			
			
			
		}
		
		//�ͷ�
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
