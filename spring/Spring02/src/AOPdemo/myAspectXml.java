package AOPdemo;

import org.aspectj.lang.ProceedingJoinPoint;


/*
 * ������  ��   ����� + ֪ͨ
 * */
public class myAspectXml {

	//֪ͨ
	public void log(){
		System.out.println("1������ǰ�ü�¼��־");
	}
	
	public void afterclose(){
		System.out.println("2�����Ǻ���֪ͨ");
	}
	
	public void errorA(){
		System.out.println("3�����Ǵ���֪ͨ");
	}
	
	public void finallyA(){
		System.out.println("4����������֪ͨ");
	}
	
	public void aroundA(ProceedingJoinPoint joinPoint){
		System.out.println("5�����ǻ���֪ͨ1");
		//�ֶ���Ŀ�����ķ���ȥִ��
		try {
			joinPoint.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("5�����ǻ���֪ͨ2");
	}
}
