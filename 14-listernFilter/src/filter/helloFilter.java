package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * filter 入门
 * */
public class helloFilter implements Filter{

	@Override
	//销毁
	public void destroy() {
		
		
	}

	@Override
	//处理逻辑业务
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("Filter 收到了请求");
		
		
		//放行
		arg2.doFilter(arg0, arg1);
		
		System.out.println("Filter 收到了响应");
	}

	@Override
	//初始化
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
