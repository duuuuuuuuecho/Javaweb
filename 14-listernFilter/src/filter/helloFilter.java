package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * filter ����
 * */
public class helloFilter implements Filter{

	@Override
	//����
	public void destroy() {
		
		
	}

	@Override
	//�����߼�ҵ��
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("Filter �յ�������");
		
		
		//����
		arg2.doFilter(arg0, arg1);
		
		System.out.println("Filter �յ�����Ӧ");
	}

	@Override
	//��ʼ��
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}