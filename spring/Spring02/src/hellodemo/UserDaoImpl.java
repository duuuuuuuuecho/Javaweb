package hellodemo;

import org.springframework.stereotype.Repository;
/*
 * ��userdaoimpl ����dao����
 * */
@Repository(value="userDao")
public class UserDaoImpl implements UserDao{

	public void save() {
		System.out.println("������dao�������");
		
	}

}
