package com.cbs.model;

public class Employee {

	private Integer id;
	private String email;
	private String name;
	private String password;
	private String department;

	public Employee() {

	}

	public Employee(Integer id, String email, String name, String password, String department) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.department = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Employee [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", department="
				+ department + "]";
	}

}
