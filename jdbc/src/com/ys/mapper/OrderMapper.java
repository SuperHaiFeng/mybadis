package com.ys.mapper;

import com.ys.po.Order;
import com.ys.po.User;

public interface OrderMapper {
	
	/**
     * 方式一：嵌套结果
     * select * from orders o,user u where o.user_id=u.id and o.id=#{id}
     * @param orderId
     * @return
     */
	//根据订单id查询订单和用户信息
	public Order selectOrderAndUserByOrderId(int orderId);
	
	/**
     * 方式二：嵌套查询
     * select * from order WHERE id=1;//得到user_id
     * select * from user WHERE id=1   //1 是上一个查询得到的user_id的值
     * @param userID
     * @return
     */
	//根据订单id查询订单信息
	public Order getOrderByOrderId(int orderId);
	
	//根据用户id查询用户信息
	public User getUserByUserId(int userId);
	
	
}
