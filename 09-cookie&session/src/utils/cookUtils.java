package utils;

import javax.servlet.http.Cookie;

public class cookUtils {
	
	
	public static  Cookie getCookieByname(String string, Cookie[] cookies) {
		// TODO Auto-generated method stub
		if(cookies!=null){
			for(Cookie c :cookies){
				if(string.equals(c.getName())){
					System.out.println("again");
					return c;
				}
			}
		}
		System.out.println("first");
		return null;
	}
}
