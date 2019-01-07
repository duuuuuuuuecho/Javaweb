package hellodemo;

import org.springframework.stereotype.Repository;
/*
 * 将userdaoimpl 交给dao容器
 * */
@Repository(value="userDao")
public class UserDaoImpl implements UserDao{

	public void save() {
		System.out.println("这里是dao层调用了");
		
	}

}
