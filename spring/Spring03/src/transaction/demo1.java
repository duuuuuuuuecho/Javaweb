package transaction;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demo1 {

	@Resource(name="accountService")
	private accountService as;
	
	/*����xml���õķ�ʽ������*/
	@Test
	public void run1(){
		
		as.pay("С��","С�ɷ�",1000);
		
	}
	
	/*����ע��ķ�ʽ������*/
	@Test
	public void run2(){
		
		 as.pay1("С��","С�ɷ�",1000);
		
	}
	
}
