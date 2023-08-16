package model;

public class Account {
	
	private String usr, pwd;
	private int rote;
	private String name,address,phone;
	private int check;

	public Account() {	
	}
	public Account(String usr, String pwd, int role, String name, String address, String phone, int check) {
		this.usr = usr;
		this.pwd = pwd;
		this.rote = role;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.check = check;
	}
	
	public String getUsr() {
		return usr;
	}
	public String getPwd() {
		return pwd;
	}
	public int getRote() {
		return rote;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public int getCheck() {
		return check;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setRote(int rote) {
		this.rote = rote;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	
	
	
}
