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
//		//��ȡ���е���Ԫ��
//		List<Element> list=root.elements();
//	    //��ȡԪ�ص�ָ����������
//		String value=root.attributeValue("������");
//	    //��ȡ�ӱ�ǩ��ǩ��:����list ��ȡ��ÿһ����Ԫ��
//		String text=ele.elementText("�ӱ�ǩ����")
		List<Element> list=root.elements();
		for(Element ele:list){
			String s = ele.elementText("servlet-name");
			System.out.println(s);
		}
		
		
		
	}

}
