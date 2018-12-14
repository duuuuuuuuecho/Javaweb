package service;

import java.sql.SQLException;
import java.util.List;

import dao.selectDao;
import domain.city;
import domain.province;

public class selectService {

	public static List<province> findallprovince() throws SQLException {
		// TODO Auto-generated method stub
		
		
		return selectDao.findallprovince();
	}

	public static List<city> findallCity(String id) throws SQLException {
		// TODO Auto-generated method stub
		return selectDao.findallCity(id);
	}

}
