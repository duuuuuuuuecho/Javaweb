package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.DataSourceUtils;
import domain.User;

public class UserDao {
	
	/*
	 * ��¼
	 * @param username �û���
	 * @param password ����
	 * @return  �û�
	 * */
	public User getUserByUsernameAndPwd(String username, String password) throws SQLException {
		//����queryrunner
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		//��дsql
		String sql="select * from user where uname=? and upassword=?";
		
		User user= qr.query(sql,new BeanHandler<>(User.class),username,password);
		return user;
	}

}
