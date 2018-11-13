import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.PatternSyntaxException;

import org.omg.IOP.RMICustomMaxStreamFormat;

import com.mysql.jdbc.Driver;

import com.mysql.jdbc.StatementImpl;
/*
 * 
		1.注册驱动.
		2.获得连接. 
		3.获得语句执行平台
		4.执行sql语句
		5.处理结果
		6.释放资源.

 * 
 * */
public class demo_connect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		//注册驱动
//		//使用java.sql.DriverManager类静态方法registerDriver(Driver driver)
//		//DriverManager.registerDriver(new Driver());    不推荐使用  浪费资源   new Driver源码中已经注册一次，相当于注册两次
//        Class.forName("com.mysql.jdbc.Driver");		
//		
//        //获得连接
//        //static Connection getConnection(String url,String name,String passwprd)
//        //url: 数据库地址 jdbc:mysql://连接主机IP：端口号/数据库名字
//        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";             //?characterEncoding=utf8  解决插入数据库后中文乱码
//        String name = "root";
//        String password = "123456";
//        Connection conn =  DriverManager.getConnection(url,name,password);
//       // System.out.println(conn);
//        
//        //获得语句执行平台
//        //		ParperStatement  更优，防注入
//        Statement statement = conn.createStatement();
//        
//        //执行sql语句
//        //int executeUpdate(string sql)   执行数据库中的sql语句      insert delete update
//        //query executeQuery(string sql)  执行数据库中的sql语句      select 
//        String sql = "insert into students_chengji(stu_name,stu_age,stu_score,stu_classroom) values('dudu',24,101,'三年五班'); ";
//        statement.executeUpdate(sql);
//        
//        
//        //释放资源
//        statement.close();
//        conn.close();
	
		//
		//***********************************************************************************************
		
		
//		Class.forName("com.mysql.jdbc.Driver");
//		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";            
//        String name = "root";
//        String password = "123456";
//		
//		Connection conn = DriverManager.getConnection(url,name,password);
//		Statement statement = conn.createStatement();
//		String sql="select * from students_chengji";
//		ResultSet rs = statement.executeQuery(sql);
//		
//		//处理结果集
//		
//		//System.out.println(rs.next());
//		while(rs.next()){
//			String xString = rs.getInt("stu_id")+" "+rs.getString("stu_name")+" "+rs.getString("stu_classroom");
//			System.out.println(xString);
//			
//			
//		}
//		
//		rs.close();
//		statement.close();
//		conn.close();
        
		//
		//***********************************************************************************************
	
		//防止注入
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";            
        String name = "root";
        String password = "123456";
		
		Connection conn = DriverManager.getConnection(url,name,password);
		String sql = "select uid from user where uname=? and upassword=?";
		PreparedStatement pst =  conn.prepareStatement(sql);
	    
		Scanner sc = new Scanner(System.in);
		
		
		String uname = sc.nextLine();
		String upassword = sc.nextLine();
		
		pst.setObject(1, uname);
	    pst.setObject(2, upassword);
		ResultSet resultSet = pst.executeQuery();
		while(resultSet.next()){
			System.out.println("ID = "+resultSet.getString("uid"));
			
		}
	    
		System.out.println("over");
		resultSet.close();
		pst.close();
		conn.close();

	
	
	
	
	
	
	
	}
	
}
