
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//���ӱ��ص����ݿ�   
//�Ѿ������õ�   qapattern
public class connectDB {
	private static String url = "jdbc:mysql://localhost:3306/subtitle";
	private static String user = "root";
	private static String password = "xiaodu";
	
	private static Connection conn = null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");    //����mysql jdbc����
			//ʵ�����ݿ������
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection fail");
			e.printStackTrace();
		}
		
		
	}
	
	public static Connection getConnection() {
		return conn;
	}
	

}
