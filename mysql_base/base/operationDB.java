


import java.sql.*;




//对数据库的简单操作   查询 增加数据  删除数据
public class operationDB {
	//增加数据  问题对
	public static void addDataDB(String question,String answer) {
		try{
		Connection connection = connectDB.getConnection();
		
		String sql="insert into qa_pattern(question,answer) values(?,?)";
		PreparedStatement ps=connection.prepareStatement(sql);//创建一个Statement对象
		ps.setString(1, question);
		ps.setString(2, answer); 
		ps.executeUpdate();
		//connection.close(); 
		/*
		String sql="insert into qapattern(question,answer) values('what is your name?','my name is dudu')";        
		Statement stmt=connection.createStatement();//创建一个Statement对象
		stmt.executeUpdate(sql);//执行sql语句
		connection.close(); */
		
		
		}catch (SQLException e) {
			// TODO: handle exception
			/*
			System.out.println("Add data fail!");
			e.printStackTrace(); */
			
		}
		
		
	}
	//按照 问题  删除
	public static  void  deleteDate(String questionName) {
		try {
			Connection connection = connectDB.getConnection();;
			Statement stmt=connection.createStatement();
			String sql="delete from qa_pattern where question="+"'"+questionName+"'";
			stmt.executeUpdate(sql);
			//connection.close();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("delete data fail!");
			e.printStackTrace();
			
		}
		
	}
	//全部查询
	public static void queryDB() throws SQLException {
		try{
		Connection connection = connectDB.getConnection();
		Statement statement = connection.createStatement();
		//查询所有数据
		ResultSet  rSet = statement .executeQuery("select *from qa_pattern"); 
		while(rSet.next()){
			System.out.println(rSet.getString("question"));
			System.out.println(rSet.getString("answer"));
		}
		//connection.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Query fail!");
		}
		
	}
	
	//通过id 得到此id下的question
	public static  String question_query(int id) {
		try{
			Connection connection = connectDB.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery(" select question from qa_pattern where id="+id);
			rset.last();
			return rset.getString(1);
						
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Query_question fail!");
			return null;
		}
		
	}  

	//通过id 得到此id下的answer
	public static  String answer_query(int id) {
		try{
			Connection connection = connectDB.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery(" select answer from qa_pattern where id="+id);
			rset.last();
			return rset.getString(1);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Query_answer fail!");
			return null;
		}
		
	}
	
	// 返回数据库的行数 
	public static  int   getROW() {
		try{
			Connection connection = connectDB.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rset = statement.executeQuery(" select * from qa_pattern");
			rset.last();
			int Row = rset.getRow();
			return Row;
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail!");
			return 0;
		}
		
		
		
	}
	
	
	/*
	public static void  main(String[] srgs) throws SQLException {
		
		
		String string = question_query(1);
		System.out.println(string);
		string = answer_query(2);
		System.out.println(string);
		System.out.println(getROW());
		
	} */
	
	
	/*
	public static void  main(String[] srgs) throws SQLException {
		queryDB();
		//addDataDB("what is your name?","my name is dudu");
		//queryDB();
		//deleteDate("what is your name?");
		//queryDB();
		//addDataDB("what is your name?","my name is dudu");
		//queryDB();
		
	} */
}
