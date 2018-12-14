package service;

import java.sql.Connection;
import java.sql.SQLException;

import utils.DataSourceUtils;
import utils.JdbcUtils;
import dao.accountDao;

public class accountService {

	
	//ԭʼ����  û��ʹ������
	public static void tranfer0(String auser, String buser, String money) throws SQLException {
		// TODO Auto-generated method stub
		accountDao dao = new accountDao();
		dao.transferMoney0(auser,buser,money);
	}
	
	//����1 ʹ������ ���´���connection
	public static void tranfer1(String auser, String buser, String money) throws Exception{
		accountDao dao = new accountDao();
		//1��������
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			
			//2ת��
			//ת��
			dao.accountOut(conn,auser,money);
			
			//���ӹ���
			//int i= 1/0;
			
			//ת��
			dao.accountIn(conn,buser,money);
			
			//3�����ύ
			conn.commit();
			//4�ͷ�����
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//����ع�
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw e;
		}
		
	}
	
	//����2���칤���� 
	// ʹ������  �����ݿ������뵱ǰ�̰߳� ��DataSourceUtils�� �ͽ����ݿ������뵱ǰ�̰߳�
	// ��DataSourceUtils��  ��װ ��������  �����ύ ����ع� 
		public static void tranfer2(String auser, String buser, String money) throws Exception{
			accountDao dao = new accountDao();
			
			try {
				//1��������
				DataSourceUtils.startTransaction();
				
				//2ת��
				//ת��
				dao.accountOut(auser,money);
				
				//���ӹ���
				//int i= 1/0;
				
				//ת��
				dao.accountIn(buser,money);
				
				//3�����ύ
				DataSourceUtils.commitAndClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//����ع�
				DataSourceUtils.rollbackAndClose();
				throw e;
			}
			
		}

	//����3   ���칤���� 
	// ʹ������  �����ݿ������뵱ǰ�̰߳� ��DataSourceUtils�� �ͽ����ݿ������뵱ǰ�̰߳�
	// ��DataSourceUtils��  ��װ ��������  �����ύ ����ع� 
	// ��Dao��ʹ��QueryRnner
		public static void tranfer3(String auser, String buser, String money) throws Exception{
			accountDao dao = new accountDao();
			
			try {
				//1��������
				DataSourceUtils.startTransaction();
				
				//2ת��
				//ת��
				dao.accountOut_QR(auser,money);
				
				//���ӹ���
				//int i= 1/0;
				
				//ת��
				dao.accountIn_QR(buser,money);
				
				//3�����ύ
				DataSourceUtils.commitAndClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//����ع�
				DataSourceUtils.rollbackAndClose();
				throw e;
			}
			
		}
}
