package ru.geochat;

import org.springframework.beans.factory.annotation.Required;

public class BusinessClass {
	
	private String name;
	private String address;
	private AnotherBean someBean;

	public String getName() {
		return name;
	}

	@Required
	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AnotherBean getSomeBean() {
		return someBean;
	}

	public void setSomeBean(AnotherBean someBean) {
		this.someBean = someBean;
	}
}
