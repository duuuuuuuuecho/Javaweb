package demo1;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * 加载properties配置文件
 * IO读取文件，键值对存储到集合中
 * 从集合中以键值对方式获取数据库连接信息
 * */
public class propertiesDome {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//使用类加载器
		//获取bin文件里面的database.properties
		InputStream fs =  propertiesDome.class.getClassLoader().getResourceAsStream("database.properties");
		Properties pro = new Properties();
		pro.load(fs);
		//获取集合中的键值对
		String driverclass = pro.getProperty("DriverClass");
		String url = pro.getProperty("url");
		String name = pro.getProperty("username");
		String password = pro.getProperty("password");
		
		
	}

}
