package connection_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;



/*
 * 
 * ����д�õ����ӳع�����
 * 
 * */
public class testdemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DataSource dataSource = JDBCPoolUtils.getDataSource();
		Connection conn = dataSource.getConnection();
		//System.out.println(conn);
		
		String sql="select * from user;";
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet resultSet = pst.executeQuery();
		while(resultSet.next()){
			System.out.println(resultSet.getString("uname"));
		}
		
	}

}
