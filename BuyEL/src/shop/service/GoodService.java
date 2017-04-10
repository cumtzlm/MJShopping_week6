package shop.service;

import java.util.List;

import shop.dao.GoodDao;
import shop.dao.GoodDaoimpl;
import shop.entity.Good;

public class GoodService {
	private GoodDao goodDao;
	public void setGoodDao() {
		this.goodDao = new GoodDaoimpl();
	}
	public List<Good> getAll(){
		return goodDao.getAll();
	}
}
