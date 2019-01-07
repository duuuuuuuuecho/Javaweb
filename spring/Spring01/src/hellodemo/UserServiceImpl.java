package hellodemo;

public class UserServiceImpl implements UserService {
	
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public void sayhello() {
		// TODO Auto-generated method stub
		System.out.println("hello spring");
	}
	
	public void sayhello1() {
		// TODO Auto-generated method stub
		System.out.println("hello spring"+name);
	}

}
