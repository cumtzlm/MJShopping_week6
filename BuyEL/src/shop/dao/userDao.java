package shop.dao;


import java.util.List;

import shop.entity.User;

public interface userDao {
	public List<User> getAll();
    public boolean updateUser(User oldUser,User newUser);
    public User getByUser_Name(User user);
	boolean deleteUser(User user);
	public boolean addUser(User user);
}
