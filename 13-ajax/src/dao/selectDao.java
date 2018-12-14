package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import utils.DataSourceUtils;
import domain.city;
import domain.province;

public class selectDao {

	public static List<province> findallprovince() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql = "select * from province";
		
		
		return qr.query(sql,new BeanListHandler<>(province.class));
		
		
	}

	public static List<city> findallCity(String id) throws SQLException {
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from city where ProvinceID = ?";
		
		return qr.query(sql,new BeanListHandler<>(city.class),id);
	}

}
