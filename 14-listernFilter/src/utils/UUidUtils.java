package utils;

import java.util.UUID;

/*
 * ���ɶ�һ�޶���id
 * */
public class UUidUtils {

		//����id
		public static String getId(){
			
			return UUID.randomUUID().toString().replace("-", "");
			
		}
		
		//���������
		public static String getCode(){
			
			return getId();
		}
}
