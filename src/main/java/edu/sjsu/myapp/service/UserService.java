package edu.sjsu.myapp.service;
import edu.sjsu.myapp.model.User;

public interface UserService {
	public abstract boolean authenticateUser(User user);
	public abstract boolean registerUser(User user);
	 
}

