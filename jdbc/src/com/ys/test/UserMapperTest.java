package com.ys.test;

import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ys.annocation.UserMapper;
import com.ys.po.User;


public class UserMapperTest {
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
	
	public void testAnnocation() throws Exception {
		///测试通过注解的方式操作数据库
		//根据session获取UserMapper接口
		UserMapper userMapper = session.getMapper(UserMapper.class);
		//调用方法
		User user = userMapper.selectUserById(1);
		System.out.println(user);
		
		User user1 = new User("android", "男", new Date(), "三里屯");
		userMapper.insertUser(user1);
		
		User user2 = new User("ok","woman",new Date(),"三里屯");
		user2.setId(2);
		userMapper.updateUserById(user2);
		
		
		userMapper.deleteUserById(4);
		session.commit();
		session.close();
	}

}
