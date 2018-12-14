package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import utils.DataSourceUtils;
import domain.products;

public class productDao {

	//查询所有商品
	public List<products> findallproducts() throws SQLException {
	
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
	
		String sql = "select * from product";
		
		return qr.query(sql,new BeanListHandler<>(products.class));
		
	}

	//添加商品
	public static void addproduct(products p) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="insert into product(pid,pname,market_price,shop_price,pdate,pdesc) values(?,?,?,?,?,?);";
		
		qr.update(sql,p.getPid(),p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdate(),p.getPdesc());
	}

	//删除商品
	public static void deleteProduct(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql= "delete from product where pid=?;";
		
		qr.update(sql,pid);
		
	}

	//根据id查询商品
	public static products findproduct(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from product where pid=?;";
		return qr.query(sql, new BeanHandler<>(products.class),pid);
		
	}

	//根据id修改商品
	public static void updateProduct(products p) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql ="update product set pname=? , market_price=? , shop_price=? , pdesc=? where pid=?;";
		qr.update(sql,p.getPname(),p.getMarket_price(),p.getShop_price(),p.getPdesc(),p.getPid());
		
	}

	//多条件查询
	public static List<products> findproductbyCondition(String name, String key) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from product where 1=1";
		ArrayList<String> params=new ArrayList<>();
		
		//判断name是否为空
		if(name!=null && name.trim().length()>0){
			sql+=(" and pname like ? ");
			params.add("%"+name+"%");
		}
		//判断key是否为空
				if(key!=null && key.trim().length()>0){
					sql+=(" and pdesc like ? ");
					params.add("%"+key+"%");
				}
		
		
		return qr.query(sql,new BeanListHandler<>(products.class),params.toArray());
	}

	//查询当前页数据
	public static List<products> showProductByPage(int currpage, int pageSize) throws SQLException {
		// TODO Auto-generated method stub

		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select * from product limit ?,?";
		
		return qr.query(sql,new BeanListHandler<>(products.class),(currpage-1)*pageSize,pageSize);
		
	}

	//查询总条数
	public static int showAllcount() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		String sql="select count(*) from product";
		return ((Long)qr.query(sql,new ScalarHandler())).intValue();
	}
	
	
	
}
