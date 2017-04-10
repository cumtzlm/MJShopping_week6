package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dbutil.Dbutil;
import shop.entity.Cart;

public class cartDaoimpl implements cartDao {

	@Override
	public List<Cart> getAll() {
		List<Cart> newsList=new ArrayList<>();
		try{
			ResultSet rs=Dbutil.executeQuery("select * from cart",new Object[]{});
			while(rs.next()){
				Cart cart=new Cart();
				cart.setUser_id(rs.getString(1));
				cart.setGnumber(rs.getString(2));
				cart.setGname(rs.getString(3));
				newsList.add(cart);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return newsList;
	}

	@Override
	public boolean addCart(Cart cart) {
		return Dbutil.executeUpdate("insert into cart value(?,?,?)", new Object[]{cart.getUser_id(),cart.getGnumber(),cart.getGname()});
	}

	@Override
	public boolean deleteCart(Cart cart) {
		return Dbutil.executeUpdate("delete from cart where k=?", new Object[]{cart.getUser_id()});
	}

	@Override
	public Cart getBygnumber(Cart cart) {
		try{
            ResultSet rs= Dbutil.executeQuery("select * from cart where user_id=?", new Object[]{cart.getGnumber()});
            while(rs.next()){
                cart.setUser_id(rs.getString("user_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cart;
	}

	@Override
	public Cart getBygname(Cart cart) {
		try{
            ResultSet rs= Dbutil.executeQuery("select * from cart where user_id=?", new Object[]{cart.getGname()});
            while(rs.next()){
                cart.setUser_id(rs.getString("user_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return cart;
	}

	@Override
	public boolean update(Cart oldcart, Cart newcart) {
		return Dbutil.executeUpdate("update cart set gnumber=?,gname=? where user_id=?",new Object[]{newcart.getGnumber(),newcart.getGname(),oldcart.getUser_id()});
		
	}

}
