package hellodemo;

 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Spring�������JUnit��Ԫ����
 * ����һ���ڳ���������:spring-test.jar
 * ��������ھ���Ĳ����������ע��
 * 		@RunWith(SpringJUnit4ClassRunner.class)
 *   	@ContextConfiguration("classpath:applicationContext.xml")
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demo2 {

	//ע��
	@Autowired
	@Qualifier(value="userService")  
	private UserService us;
	
	@Test
	public void run(){
		us.sayHello();
	}
	
	
}
