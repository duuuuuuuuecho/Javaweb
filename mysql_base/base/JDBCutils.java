import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

//JDBC工具类  
//定义方法 直接返回数据库的连接对象
//关闭方法 
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
