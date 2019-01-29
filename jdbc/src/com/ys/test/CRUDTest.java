package com.ys.test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ys.po.User;
import com.ys.vo.UserVo;


public class CRUDTest {
	//创建 sqlsessoin
	SqlSession session = null;
	
	public void init() {
		//定义mybatis全局定义
		String resource = "com/ys/mapper/mybatis-configuration.xml";
		//加载mybatis全局配置文件
		InputStream inputStream = CRUDTest.class.getClassLoader().getResourceAsStream(resource);
		//构建sqlsession工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//根据sessionFactory产生session
		session = sessionFactory.openSession();
	}
	
	//根据id查询user表
	public User testSelectUserById(Integer id) {
		/*这个字符串由 userMapper.xml 文件中 两个部分构成
        <mapper namespace="com.ys.po.userMapper"> 的 namespace 的值
        <select id="selectUserById" > id 值*/
		
		String statement = "com.ys.po.userMapper.selectUserById";
		User user = session.selectOne(statement,id);
		session.close();
		return user;
	}
	
	//查询所有user表的数据
	public List<User> testSelectUserAll() {
		String statement = "com.ys.po.userMapper.selectUserAll";
		List<User> list = session.selectList(statement);
		session.close();
		return list;
	}
	
	//模糊查询：根据user表的username字段
	public List<User> testSelectLikeUserName(String name) {
		String statement = "com.ys.po.userMapper.selectLikeUserName";
		List<User> list = session.selectList(statement,"%"+name+"%");
		session.close();
		return list;
	}
	
	//向user表中插入一条数据
	public void testInsertUser(User user) {
		String statement = "com.ys.po.userMapper.insertUser";
		session.insert(statement,user);
		session.commit();
		session.close();
	}
	
	//根据id更新user表的数据
	public void testUpdateUserById(Integer id, String name) {
		String statement = "com.ys.po.userMapper.updateUserById";
		User user = new User();
		user.setId(id);
		user.setUsername(name);
		session.update(statement,user);
		session.commit();
		session.close();
	}
	
	//根据id删除user表的数据
	public void testDeleteUserById(Integer id) {
		String statement = "com.ys.po.userMapper.deleteUserById";
		session.delete(statement, id);
		session.commit();
		session.close();
	}
	
	public void testSelectUserByListId() {
		String statement = "com.ys.po.userMapper.selectUserByListIds";
		UserVo userVo = new UserVo();
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(3);
		ids.add(5);
		userVo.setIds(ids);
		List<User> users = session.selectList(statement, userVo);
		System.out.println(users);
		session.close();
	}
}
