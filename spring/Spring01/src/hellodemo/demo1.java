package hellodemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试IoC的程序
 * */
public class demo1 {

	/*
	 * 原来方式
	 * */
	@Test
	public void run1(){
		
		//UserServiceImpl us = new UserServiceImpl();
		UserService us = new UserServiceImpl();
		us.sayhello();
	}
	
	/*
	 * 使用spring 框架方式
	 * */
	@Test
	public void run2(){
		//创建工厂   加载核心配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//从工厂中获取对象
		UserService us = (UserService) ac.getBean("userSer");
		
		//调用对象的方法执行
		us.sayhello();
		
	}
	
	/*
	 * 使用spring 框架方式
	 * 依赖注入概念的解释
	 * */
	@Test
	public void run3(){
		//创建工厂   加载核心配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//从工厂中获取对象
		UserService us = (UserService) ac.getBean("userSer");
		
		//调用对象的方法执行
		us.sayhello1();
		
	}
	
	
	
	
}
