package com.vladimir.nextstep.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InfoPerson implements Serializable {


	private String userName;
	private String userLogin;
	private String userPassword;
    private String massege;

	public String getMassege() {
		return massege;
	}
	public void setMassege(String massege) {
		
		this.massege = massege;
	}
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
