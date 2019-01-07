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
	
	/*采用xml配置的方式加事务*/
	@Test
	public void run1(){
		
		as.pay("小杜","小飞飞",1000);
		
	}
	
	/*采用注解的方式加事务*/
	@Test
	public void run2(){
		
		 as.pay1("小杜","小飞飞",1000);
		
	}
	
}
