package com.xadmin.usermanagement.model;

public class User {
	private String id;
	private String  name;
	private String email;
	private String address;
	private String phone;
	private String room;
	public User(String id, String name, String email, String address, String phone, String room) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.room = room;
	}
	public User(String name, String email, String address, String phone, String room) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.room = room;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	
	

}
