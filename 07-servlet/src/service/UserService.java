package service;

import java.sql.SQLException;

import dao.UserDao;
import domain.User;

public class UserService {
	/*
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return User 用户
	 * */
	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		//调用dao
		UserDao dao= new UserDao();
		
		return dao.getUserByUsernameAndPwd(username,password);
	}
	
}
