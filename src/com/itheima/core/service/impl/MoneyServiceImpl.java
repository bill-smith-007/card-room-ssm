package com.itheima.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.MoneyDao;
import com.itheima.core.po.Money;
import com.itheima.core.service.MoneyService;


@Service("moneyService")
@Transactional
public class MoneyServiceImpl implements MoneyService {
	// 声明DAO属性并注入
	@Autowired
	private MoneyDao moneyDao;
	public Page<Money> findMoneyList(Integer page, Integer rows, Integer Q_id, Integer M_state) {
		
		// 创建员工对象
        Money Money = new Money();
		// 判断员工名称
		if(StringUtils.isNotBlank(Q_id+"")){
			Money.setQ_id(Q_id);
		}
		// 判断员工工号
		if(StringUtils.isNotBlank(M_state+"")){
			Money.setM_state(M_state);
		}
		
		// 当前页
		Money.setStart((page-1) * rows) ;
		// 每页数
		Money.setRows(rows);
		// 查询员工列表
		List<Money> Moneys = moneyDao.selectMoneyList(Money);
		// 查询员工列表总记录数
		Integer count = moneyDao.selectMoneyListCount(Money) ;
		// 创建Page返回对象
		Page<Money> result = new Page<>();
		result.setPage(page);
		result.setRows(Moneys);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	@Override
	public int createMoney(Money Money) {
		// TODO Auto-generated method stub
		return moneyDao.createMoney(Money);
	}
	@Override
	public Money getMoneyById(Integer M_message) {
		// TODO Auto-generated method stub
		return moneyDao.getMoneyById(M_message);
	}
	@Override
	public int updateMoney(Money Money) {
		// TODO Auto-generated method stub
		return moneyDao.updateMoney(Money);
	}
	@Override
	public int deleteMoney(Integer M_message) {
		// TODO Auto-generated method stub
		return moneyDao.deleteMoney(M_message);
	}
	@Override
	public  int getRoomPrice(Integer id) {
		return moneyDao.getRoomPrice(id);
	}
//orderMoney
	@Override
	public int orderMoney(Integer M_message) {
		// TODO Auto-generated method stub
		return moneyDao.orderMoney(M_message);
	}
}
