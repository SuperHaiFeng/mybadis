package com.ys.po;

import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String sex;
    private Date birthday;
    private String address;
    
    private List<Order> orders;
    //一个用户可以分配多个角色
    private List<Role> roles;
    
    public User() {
		// TODO Auto-generated constructor stub
	}

    public User(String username, String sex, Date birthday, String address) {
		// TODO Auto-generated constructor stub
    	this.sex = sex;
    	this.username = username;
    	this.birthday = birthday;
    	this.address = address;
	}
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
    
    public List<Order> getOrders() {
		return orders;
	}
    
    public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
    
    public List<Role> getRoles() {
		return roles;
	}
    
    public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

    @Override
    public String toString() {
        return "[id=" + id + ", Username="+username + ",sex=" + sex + ", birthday=" + birthday + ", address=" + address + "]\n"+orders;
    }
}
