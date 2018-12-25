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
	//自动登录
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//1强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//2自动登录
		//2.1判断session中有没有登录用户  没有的话=自动登录
		User user = (User)request.getSession().getAttribute("user");
		if(user==null){
			//user为空  需要自动登录
			//2.2 判断访问的资源是否和登录注册相关，不相关 = 需要自动登录
			String path=request.getRequestURI();
			if(!path.contains("login")){
				//2.3获取指定cookie
				Cookie c=cookUtils.getCookieByname("autologin", request.getCookies());
				
				if(c!=null){
					//不为空
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
		
		//释放
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
