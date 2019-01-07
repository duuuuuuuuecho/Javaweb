package DIdemo;

import java.util.Arrays;
import java.util.Map;

/*
 * 集合注入的方式
 * */
public class car3 {
	
	private String[] arr;
	private Map<String,String> map;

	public void setArr(String[] arr) {
		this.arr = arr;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "car3 [arr=" + Arrays.toString(arr) + ", map=" + map + "]";
	}
	
	

	


}
