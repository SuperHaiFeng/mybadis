package com.ys.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ys.dao.IUserDao;
import com.ys.po.User;

public class UserImpl implements IUserDao{
	static SqlSession session = null;
	//读取配置文件
	static {
		try {
			String resource = "com/ys/mapper/mybatis-configuration.xml";
			//加载mybatis全局配置文件
			InputStream inputStream = UserImpl.class.getClassLoader().getResourceAsStream(resource);
			//构建sqlsession工厂
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			//根据工厂生成session
			session = factory.openSession();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		String statement = "com.ys.po.userMapper.insertUser";
		boolean flag = false;
		Object object = null;
		try {
			object = session.insert(statement, user);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean deleteUserById(int id) {
		// TODO Auto-generated method stub
		String statement = "com.ys.po.userMapper.deleteUserById";
		boolean flag = false;
		Object object = null;
		try {
			object = session.update(statement, id);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		String statement = "com.ys.po.userMapper.updateUserById";
		Object object = null;
		boolean flag = false;
		try {
			object = session.update(statement, user);
			session.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (object != null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public List<User> selectAllUsers() {
		// TODO Auto-generated method stub
		String statment = "com.ys.po.userMapper.selectUserAll";
		List<User> users = null;
		try {
			users = session.selectList(statment);
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<User> selectUserByUsername(String username) {
		// TODO Auto-generated method stub
		String statement = "com.ys.po.userMapper.selectLikeUserName";
		List<User> users = null;
		try {
			users = session.selectList(statement, username);
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		String statement = "com.ys.po.userMapper.selectUserById";
		User user = null;
		try {
			user = session.selectOne(statement, id);
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

}
