package com.ys.po;

public class Order {

	//订单id
	private int id;
	//用户id
	private int userId;
	//订单号
	private String number;
	//和用户构成一对一的关系
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number
                + ",\n user=" + user + "]";
	}
}
