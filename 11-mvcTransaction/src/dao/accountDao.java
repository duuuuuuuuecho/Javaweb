package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import utils.DataSourceUtils;
import utils.JdbcUtils;

public class accountDao {

	//ԭʼ����  û��ʹ������
	public void transferMoney0(String auser, String buser, String money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql1 = "update account set money=money-? where name=?;";
		String sql2 = "update account set money=money+? where name=?;";
		qr.update(sql1, money,auser);
		qr.update(sql2, money,buser);
	}
	
	//��������ķ���
	//ת��    ���´���connection
	public void accountOut(Connection conn, String auser, String money) throws Exception {

		// TODO Auto-generated method stub
		PreparedStatement st=null;
		try{
		String sql1 = "update account set money=money-? where name=?;";
		//�������ִ����
		st=conn.prepareStatement(sql1);
		//���ò���
		st.setString(1, money);
		st.setString(2, auser);
		
		int i = st.executeUpdate();
		System.out.println("��:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeStatement(st);
			
		}
		
	}

	//ת��   ���´���connection
	public void accountIn(Connection conn, String buser, String money) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		try{
		String sql2 = "update account set money=money+? where name=?;";
		//�������ִ����
		st=conn.prepareStatement(sql2);
		//���ò���
		st.setString(1, money);
		st.setString(2, buser);
		
		int i = st.executeUpdate();
		System.out.println("��:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			JdbcUtils.closeStatement(st);
			
		}
		
	}
	
	//ʹ�÷�װ�õĹ�����
	//ת��     
	public void accountOut(String auser, String money) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st=null;
		try{
		conn = DataSourceUtils.getConnection();
		String sql1 = "update account set money=money-? where name=?;";
		//�������ִ����
		st=conn.prepareStatement(sql1);
		//���ò���
		st.setString(1, money);
		st.setString(2, auser);
		
		int i = st.executeUpdate();
		System.out.println("��:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			
			DataSourceUtils.closeStatement(st);
			
		}
		
	}

	//ת��
	public void accountIn(String buser, String money) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement st=null;
		Connection conn = null;
		try{
		
	    conn = DataSourceUtils.getConnection();
		String sql2 = "update account set money=money+? where name=?;";
		//�������ִ����
		st=conn.prepareStatement(sql2);
		//���ò���
		st.setString(1, money);
		st.setString(2, buser);
		
		int i = st.executeUpdate();
		System.out.println("��:"+i);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			
			DataSourceUtils.closeStatement(st);
		}
		
	}

	
	//ʹ�÷�װ�õĹ�����
	//ת��
	//ʹ��QueryRunner
	public void accountOut_QR(String auser, String money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql1 = "update account set money=money-? where name=?;";
		
		qr.update(DataSourceUtils.getConnection(), sql1, money,auser);
		
	}
	//ת��
	//ʹ��QueryRunner
	public void accountIn_QR(String buser, String money) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql2 = "update account set money=money+? where name=?;";
		qr.update(DataSourceUtils.getConnection(), sql2, money,buser);
	}

}
