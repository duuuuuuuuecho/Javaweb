package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import domain.product;
import utils.DataSourceUtils;

public class productDao {

	public List<product> findallproduct() throws SQLException {
		// TODO Auto-generated method stub
		
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from product;";
		
		return qr.query(sql, new BeanListHandler<>(product.class));
		
	}

}
