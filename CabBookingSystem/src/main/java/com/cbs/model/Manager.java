package com.cbs.model;

public class Manager {

	private Integer id;
	private String name;
	private String password;
	private String department;

	public Manager() {

	}

	public Manager(Integer mgId, String mgName, String password, String department) {

		this.id = mgId;
		this.name = mgName;
		this.password = password;
		this.department = department;
	}

	public Integer getMgId() {
		return id;
	}

	public void setMgId(Integer mgId) {
		this.id = mgId;
	}

	public String getMgName() {
		return name;
	}

	public void setMgName(String mgName) {
		this.name = mgName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Manager [mgId=" + id + ", mgName=" + name + ", password=" + password + ", department=" + department
				+ "]";
	}

}
