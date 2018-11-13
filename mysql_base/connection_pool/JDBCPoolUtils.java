package connection_pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import demo1.propertiesDome;

/*
 * ʹ�����ݿ����ӳ��������ݿ�
 * ���ӳ����ã��Զ�����
 * 		���������
 * 		��������
 * 
 * 
 * */
public class JDBCPoolUtils {
	
	private static BasicDataSource dataSource = new BasicDataSource();
	private static String driverclass;
	private static String url;
	private static String name;
	private static String password;
	
	static{
		try {
			getconfirm();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dataSource.setDriverClassName(driverclass);
		dataSource.setUrl(url);
		dataSource.setUsername(name);
		dataSource.setPassword(password);
		
		//�������ӳ��е�������������
		dataSource.setInitialSize(10);    //��ʼ����������
		dataSource.setMaxActive(8);		  //�����������
		dataSource.setMaxIdle(5);         //����������   
		dataSource.setMinIdle(1);         //��С��������
		
	}
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	private static void getconfirm() throws IOException{
		InputStream fs =  propertiesDome.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(fs);
		//��ȡ�����еļ�ֵ��
		driverclass = pro.getProperty("DriverClass");
		url = pro.getProperty("url");
		name = pro.getProperty("username");
		password = pro.getProperty("password");	
	}
	
}
