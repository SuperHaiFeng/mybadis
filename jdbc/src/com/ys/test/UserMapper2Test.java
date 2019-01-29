package com.ys.test;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ys.mapper.UserMapper2;
import com.ys.po.User;

public class UserMapper2Test {
static SqlSession session = null;
	
	static {
		try {
			String resource = "com/ys/mapper/mybatis-configuration.xml";
			InputStream inputStream = CRUDTest.class.getClassLoader().getResourceAsStream(resource);
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
			session = factory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void testSelectUserById() throws Exception {
		UserMapper2 userMapper2 = session.getMapper(UserMapper2.class);
		User user = userMapper2.selectUserById(2);
		System.out.println(user);
		session.close();
	}
}
