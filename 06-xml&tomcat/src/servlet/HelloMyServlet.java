package servlet;

public class HelloMyServlet {
	public void add(){
		System.out.println("�ղ�");
	}	
	public void add(int i ,int j){
		System.out.println("˫��  "+i+"+"+j+"="+(i+j));
		
	}	
	public int add(int i){
		System.out.println("������");
		return i+1;
	}	
}
