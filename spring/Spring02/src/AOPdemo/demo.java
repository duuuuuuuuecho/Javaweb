package AOPdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * ²âÊÔAOPµÄ¹¦ÄÜ
 * 
 * */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demo {

	@Autowired
	@Qualifier(value="CustomerDao")  
	private CustomerDao Ctd;
	
	@Test
	public void run1(){
		
		Ctd.save();
		
		
	}
	
	
}
