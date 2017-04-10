package shop.dao;

import java.util.List;

import shop.entity.Cart;

public interface cartDao {
	public List<Cart> getAll();
	public boolean addCart(Cart cart);
	public Cart getBygnumber(Cart cart);
	public Cart getBygname(Cart cart);
	public boolean deleteCart(Cart cart);
	public boolean update(Cart oldcart,Cart newcart);
}
