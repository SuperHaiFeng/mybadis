package com.ys.mapper;

import java.util.List;

import com.ys.po.User;

public interface UserMapper2 {
	//基于映射
	//根据id查询user表
	public User selectUserById(int id)throws Exception;
	
	//向user表插入数据
	public void insertUser(User user) throws Exception;
	
	//根据id修改user表
	public void updateUserById(User user) throws Exception;
	
	//根据id删除user表
	public void deleteUserById(int id) throws Exception;
	
	//根据用户id查询用户信息以及下面的所有订单信息
	public User selectUserAndOrdersByUserId(int id) throws Exception;
	
	//给定一个角色id，要得到具有这个角色的所有用户信息
	public List<User> getUserByRoleId(int roleId);
	
	
}
