package service;

import java.sql.SQLException;
import java.util.List;

import dao.productDao;
import domain.pageBean;
import domain.products;

public class productService {

	//展示所有商品
	public static List<products> findall() throws SQLException {
		
		productDao dao = new productDao();
		
		return dao.findallproducts();
	
	}

	//添加商品
	public static void addProduct(products p) throws SQLException {
		
		productDao.addproduct(p);
		
		
	}

	//删除商品
	public static void deleteProductByid(String pid) throws SQLException {
		// TODO Auto-generated method stub
		productDao.deleteProduct(pid);
		
		
	}

	//通过id查询商品
	public static products findPorductByid(String pid) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.findproduct(pid);
	}

	//更新商品
	public static void updateProduct(products p) throws SQLException {
		// TODO Auto-generated method stub
		productDao.updateProduct(p);
		
	}

	//删除多个商品
	public static void deleteManyProducts(String[] ids) throws SQLException {
		// TODO Auto-generated method stub
		
		for(String id : ids){
			
			productDao.deleteProduct(id);
		}
		
	}

	//条件查询
	public static List<products> findproductbyCondition(String name, String key) throws SQLException {
		// TODO Auto-generated method stub
		
		
		return productDao.findproductbyCondition(name,key);
	}

	//分页查询
	public static pageBean<products> showProductByPage(int currpage,
			int pageSize) throws SQLException {
	
		//查询当前页数据
		List<products> list = productDao.showProductByPage(currpage,pageSize);
		
		//查询总数据条数
		int totalCount = productDao.showAllcount();
		
		return new pageBean<>(list,currpage,pageSize,totalCount);
	}

}
