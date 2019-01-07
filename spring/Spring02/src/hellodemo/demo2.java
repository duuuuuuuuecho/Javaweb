package hellodemo;

 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * Spring框架整合JUnit单元测试
 * 步骤一：在程序中引入:spring-test.jar
 * 步骤二：在具体的测试类上添加注解
 * 		@RunWith(SpringJUnit4ClassRunner.class)
 *   	@ContextConfiguration("classpath:applicationContext.xml")
 * */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class demo2 {

	//注入
	@Autowired
	@Qualifier(value="userService")  
	private UserService us;
	
	@Test
	public void run(){
		us.sayHello();
	}
	
	
}
