package filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class encodeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		//1强转
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//2放行
		chain.doFilter(new MyRequest(request), response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}

class MyRequest extends HttpServletRequestWrapper{

	private HttpServletRequest request;

	public MyRequest(HttpServletRequest request) {
		super(request);
		this.request=request;
		
	}
	
	@Override
	public String getParameter(String name) {
		//获取请求方式
		String m = request.getMethod();
		if("get".equalsIgnoreCase(m)){
			String n = request.getParameter(name);
			try {
				return new String(n.getBytes("iso8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
			
				e.printStackTrace();
			}
			
		}else if("post".equalsIgnoreCase(m)){
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return request.getParameter(name);
			
		}
		
		return super.getParameter(name);
		
		
	}
	
	
	
}
