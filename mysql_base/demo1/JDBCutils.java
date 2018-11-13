package demo1;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;

//JDBC������  
//���巽�� ֱ�ӷ������ݿ�����Ӷ���
//�رշ��� 
public class JDBCutils {

	private JDBCutils () {	}
	private static Connection conn;
	private static String driverclass;
	private static String url;
	private static String name;
	private static String password;
	
	//*****************************************************************************************
	//ֱ�Ӷ�ȡ  ���������
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
		//��ȡ�����еļ�ֵ��
		driverclass = pro.getProperty("DriverClass");
		url = pro.getProperty("url");
		name = pro.getProperty("username");
		password = pro.getProperty("password");
	}
	
	//���徲̬�������������ݿ�����Ӷ���
	public static Connection getconnection() {
		return conn;
	}
	
	//�ͷ���Դ
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
