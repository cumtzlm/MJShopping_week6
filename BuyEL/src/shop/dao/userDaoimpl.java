package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.dao.userDao;
import shop.dbutil.Dbutil;
import shop.entity.User;



public class userDaoimpl implements userDao{

	@Override
	public List<User> getAll() {
		List<User> newsList=new ArrayList<>();
		try{
			 ResultSet rs= Dbutil.executeQuery("select * from user ", new Object[]{});
			 while(rs.next()){
	                User user=new User();
	                user.setUser_id(rs.getString(1));
	                user.setUser_name(rs.getString(2));
	                user.setUser_name(rs.getString(3));
	                newsList.add(user);
	            }
		}catch(SQLException e){
			 e.printStackTrace();
		}
		 return newsList;
	}

	@Override
	public boolean updateUser(User oldUser, User newUser) {
		return Dbutil.executeUpdate("update user set user_id=?,user_name=?,user_pwd=? where user_id=?",new Object[]{newUser.getUser_id(),newUser.getUser_id(),newUser.getUser_pwd(),oldUser.getUser_id()});
	}

	@Override
	public User getByUser_Name(User user) {
		try{
            ResultSet rs= Dbutil.executeQuery("select * from user where user_name=?", new Object[]{user.getUser_name()});
            while(rs.next()){
                user.setUser_id(rs.getString("user_id"));
                //user.setUser_name (rs.getString(2));
                user.setUser_name(rs.getString("user_pwd"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
	}

	@Override
	public boolean deleteUser(User user) {
		return Dbutil.executeUpdate("delete from user where k=?", new Object[]{user.getUser_id()});
	}

	@Override
	public boolean addUser(User user) {
		System.out.println(user);
		 return Dbutil.executeUpdate("insert into user values(?,?,?)", new Object[]{user.getUser_id(),user.getUser_name(),user.getUser_pwd()});
	}

}
