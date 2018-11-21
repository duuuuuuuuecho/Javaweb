package xml;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class readxml {

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		SAXReader reader = new SAXReader();
		Document doc = reader.read("./xml/web.xml");
	
		Element root = doc.getRootElement();
//		//获取所有的子元素
//		List<Element> list=root.elements();
//	    //获取元素的指定属性内容
//		String value=root.attributeValue("属性名");
//	    //获取子标签标签体:遍历list 获取到每一个子元素
//		String text=ele.elementText("子标签名称")
		List<Element> list=root.elements();
		for(Element ele:list){
			String s = ele.elementText("servlet-name");
			System.out.println(s);
		}
		
		
		
	}

}
