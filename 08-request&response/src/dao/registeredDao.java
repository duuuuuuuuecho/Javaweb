package dao;


import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import damain.User;
import utils.DataSourceUtils;

public class registeredDao {

	public int insertUser(String username, String password, String telphone) throws SQLException {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "insert into user(uname,upassword,telphone) values(?,?,?);";
		
		
		//System.out.println(username+password+telphone);
		int line = qr.update(sql,username,password,telphone);
		
		return line;
	}

	public int insertUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "insert into user(uname,upassword,telphone) values(?,?,?);";
		int l = qr.update(sql,user.getUname(),user.getUpassword(),user.getTelphone());
		
		return l;
	}

}
