package com.itheima.core.dao;

import java.util.List;


import com.itheima.core.po.Money;


public interface MoneyDao {
	public List<Money> selectMoneyList(Money money);
	// 订单总数
	public Integer selectMoneyListCount(Money money);
	// 创建账单
	public int createMoney(Money money);
	// 通过id查询账单
	public Money getMoneyById(Integer M_message);
	// 更新账单信息
	public int updateMoney(Money money);
	// 删除账单
	int deleteMoney(Integer M_message);
	
	public int getRoomPrice(Integer id);
	//orderMoney
	int orderMoney(Integer M_message);

}
