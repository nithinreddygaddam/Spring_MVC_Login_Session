package edu.sjsu.myapp.dao;

import javax.sql.DataSource;
import edu.sjsu.myapp.model.User;
 
public interface UserDAO {
 
	public abstract void setDataSource(DataSource dataSource);
	public abstract boolean authenticateUser(User user);
	public abstract boolean registerUser(User user);
 
}
