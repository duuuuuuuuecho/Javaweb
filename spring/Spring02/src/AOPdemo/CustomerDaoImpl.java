package AOPdemo;

public class CustomerDaoImpl implements CustomerDao {

	public void save() {
		
		//int a = 10/0;
		System.out.println("保存客户");

	}

	public void update() {
		System.out.println("更新客户");

	}

}
