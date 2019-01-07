package AOPdemo;

import org.aspectj.lang.ProceedingJoinPoint;


/*
 * 切面类  ：   切入点 + 通知
 * */
public class myAspectXml {

	//通知
	public void log(){
		System.out.println("1这里是前置记录日志");
	}
	
	public void afterclose(){
		System.out.println("2这里是后置通知");
	}
	
	public void errorA(){
		System.out.println("3这里是错误通知");
	}
	
	public void finallyA(){
		System.out.println("4这里是最终通知");
	}
	
	public void aroundA(ProceedingJoinPoint joinPoint){
		System.out.println("5这里是环绕通知1");
		//手动让目标对象的方法去执行
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("5这里是环绕通知2");
	}
}
