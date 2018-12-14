package service;

import java.sql.SQLException;
import java.util.List;

import dao.userDao;
import domain.user;

public class userService {

	public static user judge(String username) throws SQLException {
		// TODO Auto-generated method stub
		return userDao.judge(username);
	}

	public static List<Object> searchkw(String kw) throws SQLException {
		
		return userDao.searchkw(kw);
		
	}

}
