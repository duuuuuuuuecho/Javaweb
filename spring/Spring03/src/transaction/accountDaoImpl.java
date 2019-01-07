package transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class accountDaoImpl extends JdbcDaoSupport implements accountDao {

	

	//¿ÛÇ®
	public void outMoney(String out, double money) {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().update("update account set money=money-? where name = ?",money,out);
	}

	//¼ÓÇ®
	public void inMoney(String in, double money) {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().update("update account set money=money+? where name = ?",money,in);
	}

}
