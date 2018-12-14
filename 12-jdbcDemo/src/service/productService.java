package service;

import java.sql.SQLException;
import java.util.List;

import dao.productDao;
import domain.pageBean;
import domain.products;

public class productService {

	//չʾ������Ʒ
	public static List<products> findall() throws SQLException {
		
		productDao dao = new productDao();
		
		return dao.findallproducts();
	
	}

	//�����Ʒ
	public static void addProduct(products p) throws SQLException {
		
		productDao.addproduct(p);
		
		
	}

	//ɾ����Ʒ
	public static void deleteProductByid(String pid) throws SQLException {
		// TODO Auto-generated method stub
		productDao.deleteProduct(pid);
		
		
	}

	//ͨ��id��ѯ��Ʒ
	public static products findPorductByid(String pid) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.findproduct(pid);
	}

	//������Ʒ
	public static void updateProduct(products p) throws SQLException {
		// TODO Auto-generated method stub
		productDao.updateProduct(p);
		
	}

	//ɾ�������Ʒ
	public static void deleteManyProducts(String[] ids) throws SQLException {
		// TODO Auto-generated method stub
		
		for(String id : ids){
			
			productDao.deleteProduct(id);
		}
		
	}

	//������ѯ
	public static List<products> findproductbyCondition(String name, String key) throws SQLException {
		// TODO Auto-generated method stub
		
		
		return productDao.findproductbyCondition(name,key);
	}

	//��ҳ��ѯ
	public static pageBean<products> showProductByPage(int currpage,
			int pageSize) throws SQLException {
	
		//��ѯ��ǰҳ����
		List<products> list = productDao.showProductByPage(currpage,pageSize);
		
		//��ѯ����������
		int totalCount = productDao.showAllcount();
		
		return new pageBean<>(list,currpage,pageSize,totalCount);
	}

}
