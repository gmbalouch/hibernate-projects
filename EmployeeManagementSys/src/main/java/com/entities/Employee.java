package com.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	private int emp_id;
	
	@Column(name="emp_name")
	private String name;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="mobile_no")
	private String mobile_no;
	
	@Column(name="email")
	private String email;
	
	
	
	public Employee() {
	
	}
	public Employee(int emp_id, String name, String gender, String address, String mobile_no, String email) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.mobile_no = mobile_no;
		this.email = email;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}
