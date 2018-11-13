package connection_pool;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;



public class DataSourceDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		/*
		 * 连接池jar包中，定义好一个BasicDataSource类
		 * 实现数据源的规范接口   javax.sql.DataSource
		 * */
		
		
		BasicDataSource dataSource = new BasicDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
		dataSource.setUsername("root");
		
		dataSource.setPassword("123456");
		
		Connection conn= dataSource.getConnection();
		System.out.println(conn);
		
	}

}
