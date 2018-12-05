package service;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import damain.User;
import dao.registeredDao;

public class registeredService {

	public static int registerUser(String username, String password,
			String telphone) throws SQLException, UnsupportedEncodingException {
		registeredDao dao =new registeredDao();
		
		int line = dao.insertUser(username,password,telphone);
		return line;
		
	}

	public static int registerUser(User user) throws SQLException {
		
		registeredDao dao =new registeredDao();
		
		int l = dao.insertUser(user);
		return l;
		// TODO Auto-generated method stub
		
	}

}
