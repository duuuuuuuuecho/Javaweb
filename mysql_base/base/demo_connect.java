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
		1.ע������.
		2.�������. 
		3.������ִ��ƽ̨
		4.ִ��sql���
		5.������
		6.�ͷ���Դ.

 * 
 * */
public class demo_connect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		//ע������
//		//ʹ��java.sql.DriverManager�ྲ̬����registerDriver(Driver driver)
//		//DriverManager.registerDriver(new Driver());    ���Ƽ�ʹ��  �˷���Դ   new DriverԴ�����Ѿ�ע��һ�Σ��൱��ע������
//        Class.forName("com.mysql.jdbc.Driver");		
//		
//        //�������
//        //static Connection getConnection(String url,String name,String passwprd)
//        //url: ���ݿ��ַ jdbc:mysql://��������IP���˿ں�/���ݿ�����
//        String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";             //?characterEncoding=utf8  ����������ݿ����������
//        String name = "root";
//        String password = "123456";
//        Connection conn =  DriverManager.getConnection(url,name,password);
//       // System.out.println(conn);
//        
//        //������ִ��ƽ̨
//        //		ParperStatement  ���ţ���ע��
//        Statement statement = conn.createStatement();
//        
//        //ִ��sql���
//        //int executeUpdate(string sql)   ִ�����ݿ��е�sql���      insert delete update
//        //query executeQuery(string sql)  ִ�����ݿ��е�sql���      select 
//        String sql = "insert into students_chengji(stu_name,stu_age,stu_score,stu_classroom) values('dudu',24,101,'�������'); ";
//        statement.executeUpdate(sql);
//        
//        
//        //�ͷ���Դ
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
//		//��������
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
	
		//��ֹע��
		
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
