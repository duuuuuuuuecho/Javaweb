package DIdemo;

public class UserServiceImpl {

	private UserDaoImpl UserDao;
	
	public void setUserDao(UserDaoImpl userDao) {
		UserDao = userDao;
	}

	public void dosth(){
		System.out.println("������serviceִ����");
		UserDao.dosth();
	}
}
