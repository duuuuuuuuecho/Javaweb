package servlet;

public class HelloMyServlet {
	public void add(){
		System.out.println("空参");
	}	
	public void add(int i ,int j){
		System.out.println("双参  "+i+"+"+j+"="+(i+j));
		
	}	
	public int add(int i){
		System.out.println("单参数");
		return i+1;
	}	
}
