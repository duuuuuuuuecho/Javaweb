package utils;

import java.util.UUID;

/*
 * 生成独一无二的id
 * */
public class UUidUtils {

		//生成id
		public static String getId(){
			
			return UUID.randomUUID().toString().replace("-", "");
			
		}
		
		//生成随机码
		public static String getCode(){
			
			return getId();
		}
}
