package AOPdemo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * ������
 * */
@Aspect
public class MyAspectAnno {

	@Before(value = "execution(public * AOPdemo.CustomDaoImpl.save())")
	public void log(){
		
		System.out.println("�����������ࣺ��¼��־");
	}
	
	@After(value = "MyAspectAnno.fin()")
	public void after(){
		System.out.println("�����������ࣺ����֪ͨ");
	}
	
	/*
	 * �Զ��������
	 * */
	@Pointcut(value = "execution(public * AOPdemo.CustomDaoImpl.save())")
	public void fin(){}
	
	
	
}
