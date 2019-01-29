package com.ys.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ys.mapper.OrderMapper;
import com.ys.mapper.UserMapper2;
import com.ys.po.Order;
import com.ys.po.User;

public class UserToOrderTest {

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
	//一对一（一个用户对应一个订单）
	public void testSelectOrderAndUserByOrderId() {
//		String statement = "com.ys.mapper.OrderMapper.selectOrderAndUserByOrderId";
//		Order order = session.selectOne(statement, 1);
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		Order order = orderMapper.selectOrderAndUserByOrderId(1);
		System.out.println(order);
		session.close();
	}
	//一对多（一个用户对应多个订单）
	public void testSelectUserAndOrdersByUserId() throws Exception {
//		String statement = "com.ys.mapper.UserMapper.selectUserAndOrdersByUserId";
//		User user = session.selectOne(statement, 1);
		UserMapper2 userMapper2 = session.getMapper(UserMapper2.class);
		User user = userMapper2.selectUserAndOrdersByUserId(1);
		System.out.println(user.getOrders());
		session.close();
	}
	
	//多对多（一个用户可以有多个角色，一个角色可以有多个用户）
	public void testGetUserByRoleId() throws Exception{
		UserMapper2 userMapper2 = session.getMapper(UserMapper2.class);
		List<User> users = userMapper2.getUserByRoleId(1);
		System.out.println(users);
		session.close();
	}
	
}
