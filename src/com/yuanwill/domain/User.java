package com.yuanwill.domain;

public class User {
	private String username;
	private int id;
	private int password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", id=" + id + ", password=" + password + "]";
	}
	

}
