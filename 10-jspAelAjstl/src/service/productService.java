package service;

import java.sql.SQLException;
import java.util.List;

import dao.productDao;
import domain.product;

public class productService {

	public static List<product> findall() throws SQLException {
		// TODO Auto-generated method stub
		productDao dao = new productDao();
		
		return dao.findallproduct();
	}

	
	
	
	
}
