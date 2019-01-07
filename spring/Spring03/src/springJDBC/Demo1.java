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
 * 演示spring 的 JDBC模板类  操作数据库 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {

	/*
	 * 演示模板类
	 * */
	@Test
	public void run1(){
		//spring内置连接池
		
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf-8");
		datasource.setUsername("root");
		datasource.setPassword("123456");
		
		//创建模板类
		JdbcTemplate template = new JdbcTemplate(datasource);
		
		template.update("insert into account values (null,?,?)", "小杜",10000);

	}
	
	/*
	 * 使用内置连接池
	 * 使用IoC的方式  测试JDBC模板类
	 * */
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Test
	public void run2(){
	
		//update 增删改
		//jdbcTemplate.update("insert into account values (null,?,?)", "美滋滋",30000);
		
		//query 查
		account ac =jdbcTemplate.queryForObject("select * from account where id = ?", new BeanMapper(), 1);
		System.out.println(ac.toString());
		
	}
	
}

/*
 * 自己手动封装数据
 * 按照行 封装数据   一行一行封装
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
