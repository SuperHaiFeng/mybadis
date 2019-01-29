package com.ys.dao;

import java.util.List;

import com.ys.po.User;

public interface IUserDao {
	/*
	 * 添加用户信息
	 */
	public boolean addUser(User user);
	/*
	 * 根据id删除用户信息
	 */
	public boolean deleteUserById(int id);
	/*
	 * 更新用户信息
	 */
	public boolean updateUser(User user);
	/*
	 * 查询所有用户信息
	 */
	public List<User> selectAllUsers();
	/*
	 * 根据用户姓名模糊查询用户信息
	 */
	public List<User> selectUserByUsername(String username);
	/*
	 * 根据用户id查询用户信息
	 */
	public User selectUserById(int id);
}
