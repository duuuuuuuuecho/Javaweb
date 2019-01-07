package hellodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * 组件注解，标记类
 * <bean id="userService" class="hellodemo.UserServiceImpl"></bean>  ==  @Component(value="userService")
 * 
 * 
 * */
@Component(value="userService")
public class UserServiceImpl implements UserService {

	@Value(value="xidian")
	private String name;
	
	//@Autowired 按照类型自动装配
	@Autowired
	@Qualifier(value="userDao")    //按名称注入
	//上面两行   可以用一行表示    @Resource(name="userDao")
	private UserDao udao;
	public void sayHello() {
		
		System.out.println("你好 spring "+name);
		udao.save();
	}

}
