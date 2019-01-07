package hellodemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/*
 * ���ע�⣬�����
 * <bean id="userService" class="hellodemo.UserServiceImpl"></bean>  ==  @Component(value="userService")
 * 
 * 
 * */
@Component(value="userService")
public class UserServiceImpl implements UserService {

	@Value(value="xidian")
	private String name;
	
	//@Autowired ���������Զ�װ��
	@Autowired
	@Qualifier(value="userDao")    //������ע��
	//��������   ������һ�б�ʾ    @Resource(name="userDao")
	private UserDao udao;
	public void sayHello() {
		
		System.out.println("��� spring "+name);
		udao.save();
	}

}
