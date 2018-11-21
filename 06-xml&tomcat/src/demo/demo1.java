package demo;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import servlet.HelloMyServlet;

import org.junit.Test;

// ���ֿ�����÷�������ʽ 
public class demo1 {
	
	@Test
	public void f0(){
		HelloMyServlet a0 = new HelloMyServlet();
		a0.add(1,2);

	}
	
	@Test
	public void f1() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		//������ص��ڴ�
		Class cla = Class.forName("servlet.HelloMyServlet");
		//ͨ���ֽ�����󴴽�һ��ʵ������
		HelloMyServlet a = (HelloMyServlet) cla.newInstance();
		a.add(1,2);
	}
	
	@Test
	public void f2() throws Exception{
		Class cla = Class.forName("servlet.HelloMyServlet");
		HelloMyServlet a = (HelloMyServlet) cla.newInstance();
		
		//��ȡ��������   
		//��ȡ�ղ�
		Method method = cla.getMethod("add");
		//�÷�������ִ��    obj ���÷�����ʵ��   args ����
		//method.invoke(a, args)
		method.invoke(a);
		
		//��ȡ��������
		//��ȡ�����
		Method method1 = cla.getMethod("add",int.class,int.class);
		method1.invoke(a,1,2);
	}
	
	
	
	
}
