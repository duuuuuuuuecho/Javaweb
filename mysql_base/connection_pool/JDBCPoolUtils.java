package connection_pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import demo1.propertiesDome;

/*
 * 使用数据库连接池连接数据库
 * 连接池配置，自定义类
 * 		最基本四项
 * 		其他配置
 * 
 * 
 * */
public class JDBCPoolUtils {
	
	private static BasicDataSource dataSource = new BasicDataSource();
	private static String driverclass;
	private static String url;
	private static String name;
	private static String password;
	
	static{
		try {
			getconfirm();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setDriverClassName(driverclass);
		dataSource.setUrl(url);
		dataSource.setUsername(name);
		dataSource.setPassword(password);
		
		//配置连接池中的连接数量配置
		dataSource.setInitialSize(10);    //初始化连接数量
		dataSource.setMaxActive(8);		  //最大连接数量
		dataSource.setMaxIdle(5);         //最大空闲连接   
		dataSource.setMinIdle(1);         //最小空闲连接
		
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	private static void getconfirm() throws IOException{
		InputStream fs =  propertiesDome.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(fs);
		//获取集合中的键值对
		driverclass = pro.getProperty("DriverClass");
		url = pro.getProperty("url");
		name = pro.getProperty("username");
		password = pro.getProperty("password");	
	}
	
}
