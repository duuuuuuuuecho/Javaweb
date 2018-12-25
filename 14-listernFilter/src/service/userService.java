package service;

import java.sql.SQLException;

import dao.userDao;
import domain.User;

public class userService {

	public static User login(String uname, String upassword) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.login(uname,upassword);
	}

}
