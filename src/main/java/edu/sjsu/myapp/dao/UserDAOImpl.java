package edu.sjsu.myapp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Component;

import edu.sjsu.myapp.model.User;
 
@SuppressWarnings("deprecation")
@Component
public class UserDAOImpl implements UserDAO {
 
	private SimpleJdbcTemplate simpleJdbcTemplate;
 
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}
 
	public boolean authenticateUser(User user){
		boolean userExists = false;
 
		/* Provide table name and column name carefully in the sql query below.
		 * here i have a table "user" with two column's
		 * "userId" and "password" both of varchar2 type.
		 */
		int rowcount = simpleJdbcTemplate.queryForInt("select count(*) from user" +
				" where userId = ? and password = ?",
				user.getUserId(),user.getPassword());
		if(rowcount==1){
			userExists = true;
		}
		return userExists;
	}
	
	public boolean registerUser(User user){
		boolean userRegistered = true;
			
		int rowcount = simpleJdbcTemplate.queryForInt("select count(*) from user" + " where userId = ?", user.getUserId());
		
		if(rowcount==0){
			simpleJdbcTemplate.update("insert into user " + "(userId, password) values (?, ?)", user.getUserId(),user.getPassword());
		}
		else{
			userRegistered = false;
		}
		
		return userRegistered;
	}
 
}
