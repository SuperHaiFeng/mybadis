package com.ys.test;

import java.util.Date;

import com.ys.impl.UserImpl;
import com.ys.po.User;

public class TestMain {
	public static void main(String[] args) throws Exception{
//		testCRUD();
//		testUserImpl();
//		testAnnocation();
//		testUserMapper2();
//		testOrderOneToOne();
//		testGetUserByRoleId();
//		testLazy();
		testTwoCache();
	}
	public static void testCRUD() {
		CRUDTest test = new CRUDTest();
		test.init();
		test.testSelectUserByListId();
	}
	
	public static void testUserImpl() {
		UserImpl userImpl = new UserImpl();
		System.out.println(userImpl.selectAllUsers());
	}
	
	public static void testAnnocation() throws Exception {
		UserMapperTest userMapperTest = new UserMapperTest();
		userMapperTest.testAnnocation();
	}
	
	public static void testUserMapper2() throws Exception  {
		UserMapper2Test userMapper2Test = new UserMapper2Test();
		userMapper2Test.testSelectUserById();
	}
	
	public static void testOrderOneToOne() throws Exception {
		UserToOrderTest orderOnToOneTest = new UserToOrderTest();
		orderOnToOneTest.testSelectOrderAndUserByOrderId();
	}
	
	public static void testUserToOrders() throws Exception{
		UserToOrderTest orderOnToOneTest = new UserToOrderTest();
		orderOnToOneTest.testSelectUserAndOrdersByUserId();
	}
	
	public static void testGetUserByRoleId() throws Exception{
		UserToOrderTest userToOrderTest = new UserToOrderTest();
		userToOrderTest.testGetUserByRoleId();
	}
	
	public static void testLazy() {
		TestLazySql testLazySql = new TestLazySql();
		testLazySql.testLazy();
	}
	
	public static void testTwoCache() throws Exception{
		TestTwoCache testTwoCache = new TestTwoCache();
		testTwoCache.testTwoSessionSelect();
		testTwoCache.testTwoSessionUpdateAndSelect();
	}
	
}
