package connection_pool;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 使用C3P0数据库连接池连接数据库
 * 连接池配置，自定义类
 * 
 * 
 * */

public class c3p0Pool {

	
	//硬编码

	public void demo1() throws PropertyVetoException, SQLException {
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUser("root");
		dataSource.setPassword("123456");
		Connection conn =  dataSource.getConnection();
		String sql="select * from user;";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet resultSet = pst.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getString("uname"));
		}
		pst.close();
		resultSet.close();
		conn.close();
	}
	
	@Test
	//读取配置文件
	//默认读取 
	//      c3p0.properties配置文件
	//      或
	//		c3p0-config.xml配置文件
	//方便
	public void demo2() throws SQLException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		Connection conn =  dataSource.getConnection();
		String sql="select * from user;";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet resultSet = pst.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getString("uname"));
		}
		pst.close();
		resultSet.close();
		conn.close();
		
	}
	
}
