package shop.service;

import shop.dao.cartDao;
import shop.dao.cartDaoimpl;
import shop.entity.Cart;

public class CartService {
	private cartDao cartDao;
	public void setCartDao(cartDao userDao){
		this.cartDao=new cartDaoimpl();
	}
	public boolean addCart(Cart cart){
		return cartDao.addCart(cart);	
	}
	public boolean deleteCart(Cart cart){
		return cartDao.deleteCart(cart);
	}
	public Cart getByGname(Cart cart){
        return cartDao.getBygname(cart);
	}
	public Cart getByGnumber(Cart cart){
        return cartDao.getBygnumber(cart);
	}
	public boolean updateCart(Cart oldcart,Cart newcart){
		return cartDao.update(oldcart, newcart);
	}
	
}
