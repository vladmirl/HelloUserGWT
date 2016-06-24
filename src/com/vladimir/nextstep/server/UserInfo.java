package com.vladimir.nextstep.server;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserInfo implements Serializable {
	
	private String userName;
	private String userLogin;
	private String userPassword;

		
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
