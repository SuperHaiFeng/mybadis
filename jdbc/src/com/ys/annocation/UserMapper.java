package com.ys.annocation;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ys.po.User;

public interface UserMapper {
	///通过注解的方式操作数据库
	/*
	 * 根据id查询user 表
	 */
	@Select("select * from user where id = #{id}")
	public User selectUserById(int id) throws Exception;
	
	/*
	 * 向user表插入一条数据
	 */
	@Insert("insert into user(username,sex,birthday,address) values(#{username}, #{sex}, #{birthday}, #{address})")
	public void insertUser(User user) throws Exception;
	
	/*
	 * 根据id修改user信息
	 */
	@Update("update user set username=#{username}, sex=#{sex}, birthday=#{birthday}, address=#{address} where id=#{id}")
	public void updateUserById(User user) throws Exception;
	
	/*
	 * 根据id删除user
	 */
	@Delete("delete from user where id=#{id}")
	public void deleteUserById(int id) throws Exception;
}
