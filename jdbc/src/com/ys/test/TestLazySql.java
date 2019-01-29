package com.ys.test;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ys.mapper.lazy.OrderMapper;
import com.ys.po.Order;

public class TestLazySql {

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
	
	public void testLazy() {
		OrderMapper orderMapper = session.getMapper(OrderMapper.class);
		List<Order> orders = orderMapper.getOrders();
		System.out.println(orders);
		session.close();
	}
}
