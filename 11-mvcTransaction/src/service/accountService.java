package service;

import java.sql.Connection;
import java.sql.SQLException;

import utils.DataSourceUtils;
import utils.JdbcUtils;
import dao.accountDao;

public class accountService {

	
	//原始方法  没有使用事务
	public static void tranfer0(String auser, String buser, String money) throws SQLException {
		// TODO Auto-generated method stub
		accountDao dao = new accountDao();
		dao.transferMoney0(auser,buser,money);
	}
	
	//方法1 使用事务 向下传递connection
	public static void tranfer1(String auser, String buser, String money) throws Exception{
		accountDao dao = new accountDao();
		//1开启事务
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);
			
			//2转账
			//转出
			dao.accountOut(conn,auser,money);
			
			//增加故障
			//int i= 1/0;
			
			//转入
			dao.accountIn(conn,buser,money);
			
			//3事务提交
			conn.commit();
			//4释放连接
			JdbcUtils.closeConn(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//事务回滚
			conn.rollback();
			JdbcUtils.closeConn(conn);
			throw e;
		}
		
	}
	
	//方法2构造工具类 
	// 使用事务  将数据库连接与当前线程绑定 在DataSourceUtils中 就将数据库连接与当前线程绑定
	// 在DataSourceUtils中  封装 开启事务  事务提交 事务回滚 
		public static void tranfer2(String auser, String buser, String money) throws Exception{
			accountDao dao = new accountDao();
			
			try {
				//1开启事务
				DataSourceUtils.startTransaction();
				
				//2转账
				//转出
				dao.accountOut(auser,money);
				
				//增加故障
				//int i= 1/0;
				
				//转入
				dao.accountIn(buser,money);
				
				//3事务提交
				DataSourceUtils.commitAndClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//事务回滚
				DataSourceUtils.rollbackAndClose();
				throw e;
			}
			
		}

	//方法3   构造工具类 
	// 使用事务  将数据库连接与当前线程绑定 在DataSourceUtils中 就将数据库连接与当前线程绑定
	// 在DataSourceUtils中  封装 开启事务  事务提交 事务回滚 
	// 在Dao中使用QueryRnner
		public static void tranfer3(String auser, String buser, String money) throws Exception{
			accountDao dao = new accountDao();
			
			try {
				//1开启事务
				DataSourceUtils.startTransaction();
				
				//2转账
				//转出
				dao.accountOut_QR(auser,money);
				
				//增加故障
				//int i= 1/0;
				
				//转入
				dao.accountIn_QR(buser,money);
				
				//3事务提交
				DataSourceUtils.commitAndClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				//事务回滚
				DataSourceUtils.rollbackAndClose();
				throw e;
			}
			
		}
}
