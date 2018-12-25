package dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.DataSourceUtils;
import domain.User;

public class userDao {

	public static User login(String uname, String upassword) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr= new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from user where uname=? and upassword=? limit 1";
		
		return qr.query(sql,new BeanHandler<>(User.class),uname,upassword);
		
		
	}

}
