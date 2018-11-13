package demo1;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
/*
 * 
 * 读取工具类中的方法 
 * 		从配置文件中数据库参数	  
 * 		连接数据库
 * 		关闭数据库
 * 
 * 将返回结果封装进用户类
 * 
 * */
public class demo1 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn= JDBCutils.getconnection();
		String sql = "select * from user ";
		PreparedStatement stat = conn.prepareStatement(sql);
		
		ResultSet resultSet= stat.executeQuery();
		
		List<userdemo> sList = new ArrayList<userdemo>();
		
		while(resultSet.next()){
			userdemo userdemo1 = new userdemo(resultSet.getInt("uid"),resultSet.getString("uname"),resultSet.getString("upassword"),resultSet.getString("telphone"));
			sList.add(userdemo1);
		}
		
		for(userdemo x:sList){
			System.out.println(x);
		}
		
		JDBCutils.close(conn, stat,resultSet);
		
	}

}
