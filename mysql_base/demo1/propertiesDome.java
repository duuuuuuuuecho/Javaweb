package demo1;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * ����properties�����ļ�
 * IO��ȡ�ļ�����ֵ�Դ洢��������
 * �Ӽ������Լ�ֵ�Է�ʽ��ȡ���ݿ�������Ϣ
 * */
public class propertiesDome {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//ʹ���������
		//��ȡbin�ļ������database.properties
		InputStream fs =  propertiesDome.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(fs);
		//��ȡ�����еļ�ֵ��
		String driverclass = pro.getProperty("DriverClass");
		String url = pro.getProperty("url");
		String name = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		
	}

}
