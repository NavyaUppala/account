package com.capitalone.AccountServiceProducer.model;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	public Integer customerId;

	private String fname;
	private String lname;
	private Integer age;

	private String accountOpenDate;

	private Double acctBalance;

	private Address address;

	private List<Phone> phones;

	public Customer() {
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getAccountOpenDate() {
		return accountOpenDate;
	}

	public void setAccountOpenDate(String accountOpenDate) {
		this.accountOpenDate = accountOpenDate;
	}

	public Double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(Double acctBalance) {
		this.acctBalance = acctBalance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fname=" + fname + ", lname=" + lname + ", age=" + age
				+ ", accountOpenDate=" + accountOpenDate + ", acctBalance=" + acctBalance + ", address=" + address
				+ ", phones=" + phones + "]";
	}

	
}
