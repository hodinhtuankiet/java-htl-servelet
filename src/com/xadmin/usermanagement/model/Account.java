package com.xadmin.usermanagement.model;

public class Account {
	private String uname;
	private String uemail;
	private String upassword;
	private String ucontact;
	public Account(String uname, String uemail, String upassword, String ucontact) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.ucontact = ucontact;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUcontact() {
		return ucontact;
	}
	public void setUcontact(String ucontact) {
		this.ucontact = ucontact;
	}
	
}
