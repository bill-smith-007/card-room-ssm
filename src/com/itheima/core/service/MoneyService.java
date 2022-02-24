package com.itheima.core.service;


import com.itheima.common.utils.Page;
import com.itheima.core.po.Money;

public interface MoneyService {
	// 查询员工列表
	public Page<Money> findMoneyList(Integer page, Integer rows, 
	                           Integer Q_id,Integer M_state);
	//新增员工
	public int createMoney(Money money);
	// 通过id查询员工
	public Money getMoneyById(Integer M_message);
	// 更新员工
	public int updateMoney(Money money);
	// 删除员工
	public int deleteMoney(Integer M_message);
	public int getRoomPrice(Integer id);
	public int orderMoney(Integer M_message);
	//orderMoney
}
