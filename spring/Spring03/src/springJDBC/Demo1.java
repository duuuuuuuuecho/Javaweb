package springJDBC;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * ��ʾspring �� JDBCģ����  �������ݿ� 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {

	/*
	 * ��ʾģ����
	 * */
	@Test
	public void run1(){
		//spring�������ӳ�
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		
		//����ģ����
		JdbcTemplate template = new JdbcTemplate(datasource);
		
		template.update("insert into account values (null,?,?)", "С��",10000);

	}
	
	/*
	 * ʹ���������ӳ�
	 * ʹ��IoC�ķ�ʽ  ����JDBCģ����
	 * */
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void run2(){
	
		//update ��ɾ��
		//jdbcTemplate.update("insert into account values (null,?,?)", "������",30000);
		
		//query ��
		account ac =jdbcTemplate.queryForObject("select * from account where id = ?", new BeanMapper(), 1);
		System.out.println(ac.toString());
		
	}
	
}

/*
 * �Լ��ֶ���װ����
 * ������ ��װ����   һ��һ�з�װ
 * */
class BeanMapper implements RowMapper<account>{

	public account mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		account ac = new account();
		ac.setId(arg0.getInt("id"));
		ac.setName(arg0.getString("name"));
		ac.setMoney(arg0.getDouble("money"));
		return ac;
	}
	
	
}
