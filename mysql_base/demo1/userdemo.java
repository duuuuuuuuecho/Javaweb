package demo1;

public class userdemo {
	
	private int id;
	private String name;
	private String password;
	private String tel;
	
	@Override
	public String toString() {
		return "userdemo [id=" + id + ", name=" + name + ", password=" + password + ", tel=" + tel + "]";
	}

	public userdemo() {}
	
	public userdemo(int a,String b,String c,String d) {
		this.id=a;
		this.name=b;
		this.password=c;
		this.tel=d;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
