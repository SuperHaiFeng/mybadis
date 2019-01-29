package com.ys.po;

import java.util.List;

public class Role {

	private int id;
	private String name;
	//一个角色可以分配多个用户
	private List<User> users;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "role [id="+id+"name="+name+"users="+users+"]";
	}
}
