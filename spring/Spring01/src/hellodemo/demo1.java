package hellodemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ����IoC�ĳ���
 * */
public class demo1 {

	/*
	 * ԭ����ʽ
	 * */
	@Test
	public void run1(){
		
		//UserServiceImpl us = new UserServiceImpl();
		UserService us = new UserServiceImpl();
		us.sayhello();
	}
	
	/*
	 * ʹ��spring ��ܷ�ʽ
	 * */
	@Test
	public void run2(){
		//��������   ���غ��������ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//�ӹ����л�ȡ����
		UserService us = (UserService) ac.getBean("userSer");
		
		//���ö���ķ���ִ��
		us.sayhello();
		
	}
	
	/*
	 * ʹ��spring ��ܷ�ʽ
	 * ����ע�����Ľ���
	 * */
	@Test
	public void run3(){
		//��������   ���غ��������ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//�ӹ����л�ȡ����
		UserService us = (UserService) ac.getBean("userSer");
		
		//���ö���ķ���ִ��
		us.sayhello1();
		
	}
	
	
	
	
}
