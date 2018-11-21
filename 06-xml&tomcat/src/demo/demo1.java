package demo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import servlet.HelloMyServlet;

import org.junit.Test;

// 几种跨包调用方法的形式 
public class demo1 {
	
	@Test
	public void f0(){
		HelloMyServlet a0 = new HelloMyServlet();
		a0.add(1,2);

	}
	
	@Test
	public void f1() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		//将类加载到内存
		Class cla = Class.forName("servlet.HelloMyServlet");
		//通过字节码对象创建一个实例对象
		HelloMyServlet a = (HelloMyServlet) cla.newInstance();
		a.add(1,2);
	}
	
	@Test
	public void f2() throws Exception{
		Class cla = Class.forName("servlet.HelloMyServlet");
		HelloMyServlet a = (HelloMyServlet) cla.newInstance();
		
		//获取方法对象   
		//获取空参
		Method method = cla.getMethod("add");
		//让方法对象执行    obj 调用方法的实例   args 参数
		//method.invoke(a, args)
		method.invoke(a);
		
		//获取方法对象
		//获取多参数
		Method method1 = cla.getMethod("add",int.class,int.class);
		method1.invoke(a,1,2);
	}
	
	
	
	
}
