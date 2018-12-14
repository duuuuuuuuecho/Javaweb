package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import utils.DataSourceUtils;
import utils.JdbcUtils;

public class accountDao {

	//原始方法  没有使用事务
	public void transferMoney0(String auser, String buser, String money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql1 = "update account set money=money-? where name=?;";
		String sql2 = "update account set money=money+? where name=?;";
		qr.update(sql1, money,auser);
		qr.update(sql2, money,buser);
	}
	
	//增加事务的方法
	//转出    向下传递connection
	public void accountOut(Connection conn, String auser, String money) throws Exception {

		// TODO Auto-generated method stub
		PreparedStatement st=null;
		try{
		String sql1 = "update account set money=money-? where name=?;";
		//创建语句执行者
		st=conn.prepareStatement(sql1);
		//设置参数
		st.setString(1, money);
		st.setString(2, auser);
		
		int i = st.executeUpdate();
		System.out.println("出:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeStatement(st);
			
		}
		
	}

	//转入   向下传递connection
	public void accountIn(Connection conn, String buser, String money) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		try{
		String sql2 = "update account set money=money+? where name=?;";
		//创建语句执行者
		st=conn.prepareStatement(sql2);
		//设置参数
		st.setString(1, money);
		st.setString(2, buser);
		
		int i = st.executeUpdate();
		System.out.println("收:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeStatement(st);
			
		}
		
	}
	
	//使用封装好的工具类
	//转出     
	public void accountOut(String auser, String money) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st=null;
		try{
		conn = DataSourceUtils.getConnection();
		String sql1 = "update account set money=money-? where name=?;";
		//创建语句执行者
		st=conn.prepareStatement(sql1);
		//设置参数
		st.setString(1, money);
		st.setString(2, auser);
		
		int i = st.executeUpdate();
		System.out.println("出:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			
			DataSourceUtils.closeStatement(st);
			
		}
		
	}

	//转入
	public void accountIn(String buser, String money) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		Connection conn = null;
		try{
		
	    conn = DataSourceUtils.getConnection();
		String sql2 = "update account set money=money+? where name=?;";
		//创建语句执行者
		st=conn.prepareStatement(sql2);
		//设置参数
		st.setString(1, money);
		st.setString(2, buser);
		
		int i = st.executeUpdate();
		System.out.println("收:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			
			DataSourceUtils.closeStatement(st);
		}
		
	}

	
	//使用封装好的工具类
	//转出
	//使用QueryRunner
	public void accountOut_QR(String auser, String money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql1 = "update account set money=money-? where name=?;";
		
		qr.update(DataSourceUtils.getConnection(), sql1, money,auser);
		
	}
	//转入
	//使用QueryRunner
	public void accountIn_QR(String buser, String money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql2 = "update account set money=money+? where name=?;";
		qr.update(DataSourceUtils.getConnection(), sql2, money,buser);
	}

}
