package com.cbs.model;

public class Admin {

	private Integer adminID;
	private String userName;
	private String password;

	public Admin(Integer adminID, String userName, String password) {

		this.adminID = adminID;
		this.userName = userName;
		this.password = password;
	}

	public Admin() {

	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", userName=" + userName + ", password=" + password + "]";
	}

}
