package shop.service;

import shop.dao.userDao;
import shop.dao.userDaoimpl;
import shop.entity.User;

public class UserService {
	private userDao userDao; 

	public void setUserDao(userDao userDao) {
		this.userDao = new userDaoimpl();
	}
	public boolean addUser(User user){
		
		  return userDao.addUser(user);
	  }
	  public boolean deleteUser(User user){
			return userDao.deleteUser(user);		
		}
	  public boolean updateUser(User oldUser,User newUser){
			return userDao.updateUser(oldUser, newUser);
		}
	 public User getByUser_Name(User user){
	        return userDao.getByUser_Name(user);
	}
	public void setUserDao() {
		this.userDao = new userDaoimpl();
		
	}
	
		
	}

