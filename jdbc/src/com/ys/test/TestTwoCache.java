package com.ys.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ys.mapper.UserMapper2;
import com.ys.po.User;

public class TestTwoCache {
	static SqlSessionFactory factory = null;
	
	static {
		try {
			//两个Sqlsession，如果关闭一个，另一个同样的查询一条语句，也是从缓存中区
			String resource = "com/ys/mapper/mybatis-configuration.xml";
			InputStream inputStream = CRUDTest.class.getClassLoader().getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//测试二级缓存
	public void testTwoSessionSelect() throws Exception {
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		
//		String statement = "com.ys.mapper.UserMapper2.selectUserById";
		UserMapper2 userMapper1 = session1.getMapper(UserMapper2.class);
		UserMapper2 userMapper2 = session2.getMapper(UserMapper2.class);
		
		//第一次查询
		User user = userMapper1.selectUserById(1);
		System.out.println(user);
		session1.close();
		
		//第二次查询
		User user2 = userMapper2.selectUserById(1);
		System.out.println(user2);
		session2.close();
	}
	
	public void testTwoSessionUpdateAndSelect() throws Exception {
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		SqlSession session3 = factory.openSession();
		
		UserMapper2 userMapper1 = session1.getMapper(UserMapper2.class);
		UserMapper2 userMapper2 = session2.getMapper(UserMapper2.class);
		UserMapper2 userMapper3 = session3.getMapper(UserMapper2.class);
		
		//第一次查询
		User user = userMapper1.selectUserById(2);
		System.out.println(user);
		session1.close();
		
		//更新操作
		user.setAddress("山东");
		userMapper3.updateUserById(user);
		session3.commit();
		session3.close();
		
		//第二次查询,由于上次更新操作，缓存数据已经清空（防止数据脏读），这里必须再次发出sql语句
		User user2 = userMapper2.selectUserById(2);
		System.out.println(user2);
		session2.close();
	}

}
