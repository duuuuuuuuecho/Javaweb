package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import utils.DataSourceUtils;
import domain.user;

public class userDao {

	public static user judge(String username) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where uname=? limit 1";
		
		return qr.query(sql,new BeanHandler<>(user.class),username);
	}

	public static List<Object> searchkw(String kw) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select kw from keyword where kw like ? limit 5";
		return qr.query(sql, new ColumnListHandler("kw"),"%"+kw+"%");
	}

}
