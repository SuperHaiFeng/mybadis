package com.ys.mapper.lazy;

import java.util.List;

import com.ys.po.Order;
import com.ys.po.User;

public interface OrderMapper {
	//单表分表查询（懒加载，根据需要查询表格）
		//得到订单信息（包含用户id）
		public List<Order> getOrders();
		
		//根据用户id查询用户信息
		public User getUserByUserId(int userId);
}
