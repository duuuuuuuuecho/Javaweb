package AOPdemo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * 切面类
 * */
@Aspect
public class MyAspectAnno {

	@Before(value = "execution(public * AOPdemo.CustomDaoImpl.save())")
	public void log(){
		
		System.out.println("这里是切面类：记录日志");
	}
	
	@After(value = "MyAspectAnno.fin()")
	public void after(){
		System.out.println("这里是切面类：最终通知");
	}
	
	/*
	 * 自定义切入点
	 * */
	@Pointcut(value = "execution(public * AOPdemo.CustomDaoImpl.save())")
	public void fin(){}
	
	
	
}
