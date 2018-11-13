package demo1;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

//JDBC工具类  
//定义方法 直接返回数据库的连接对象
//关闭方法 
public class JDBCutils {

	private JDBCutils () {	}
	private static Connection conn;
	private static String driverclass;
	private static String url;
	private static String name;
	private static String password;
	
	//*****************************************************************************************
	//直接读取  不方便更改
	/*
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";            
        String name = "root";
        String password = "123456";
		try {
			conn = DriverManager.getConnection(url,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	//*****************************************************************************************
	
	static {
		
		
		try {
			try {
				readconfig();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Class.forName(driverclass);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private static void readconfig() throws IOException{
		InputStream fs =  propertiesDome.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(fs);
		//获取集合中的键值对
		driverclass = pro.getProperty("DriverClass");
		url = pro.getProperty("url");
		name = pro.getProperty("username");
		password = pro.getProperty("password");
	}
	
	//定义静态方法，返回数据库的连接对象
	public static Connection getconnection() {
		return conn;
	}
	
	//释放资源
	public static void close(Connection con, Statement stat, ResultSet rs) throws SQLException{
		if(con!=null){
			con.close();
		}
		if(stat!=null){
			stat.close();
		}
		if(rs!=null){
			rs.close();
		}
		
	}
	
	public static void close(Connection con, Statement stat) throws SQLException{
		if(con!=null){
			con.close();
		}
		if(stat!=null){
			stat.close();
		}
		
		
	}
	
	
	
}
