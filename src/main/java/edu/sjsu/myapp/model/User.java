package edu.sjsu.myapp.model;

import java.io.Serializable;
 
import org.hibernate.validator.constraints.NotEmpty;
public class User implements Serializable{
 
	private static final long serialVersionUID = 4657462015039726030L;
 
	//spring validation 
	@NotEmpty(message="UserId cannot be empty")
	private String userId;
	@NotEmpty(message="Password cannot be empty")
	private String password;
 
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
}
