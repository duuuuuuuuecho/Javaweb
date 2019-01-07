package DIdemo;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class demo {

	/*
	 * 演示依赖注入
	 * */
	
	public void run0(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServiceImpl us = (UserServiceImpl) ac.getBean("UService");
		us.dosth();
		
	}	
	
	/*
	 * 演示构造方法的注入方式
	 * */
	@Test
	public void run1(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		car1 c = (car1) ac.getBean("car1");
		System.out.println(c);
		
	}
	
	@Test
	public void run2(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		car2 c = (car2) ac.getBean("car2");
		System.out.println(c);
		
	}
	
	/*
	 * 测试注入集合
	 * */
	@Test
	public void run3(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		car3 c = (car3) ac.getBean("car3");
		System.out.println(c);
		
	}
	
}
