package edu.sjsu.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
 
import edu.sjsu.myapp.model.User;
import edu.sjsu.myapp.dao.UserDAO;
 
@Component
public class UserServiceImpl implements UserService {
 
	@Autowired
	private UserDAO userDAO;
 
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public UserDAO getUserDAO() {
		return userDAO;
	}
 
	public boolean authenticateUser(User user){
		return userDAO.authenticateUser(user);
	}
	
	public boolean registerUser(User user){
		return userDAO.registerUser(user);
	}
}
