package service;

import java.sql.SQLException;

import dao.UserDao;
import domain.User;

public class UserService {
	/*
	 * �û���¼
	 * @param username �û���
	 * @param password ����
	 * @return User �û�
	 * */
	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		//����dao
		UserDao dao= new UserDao();
		
		return dao.getUserByUsernameAndPwd(username,password);
	}
	
}
