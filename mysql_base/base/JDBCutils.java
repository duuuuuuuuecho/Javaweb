import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

//JDBC������  
//���巽�� ֱ�ӷ������ݿ�����Ӷ���
//�رշ��� 
public class JDBCutils {

	private JDBCutils () {	}
	private static Connection conn;
	
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
