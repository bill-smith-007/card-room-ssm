package com.itheima.core.web.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Help;
import com.itheima.common.utils.Page;

import com.itheima.core.po.Money;
import com.itheima.core.po.User;
import com.itheima.core.service.MoneyService;


@Controller
public class MoneyController {
	// 依赖注入
	@Autowired
	private MoneyService moneyService;
	
	/**
	 *  员工列表
	 */
	@RequestMapping(value = "/money/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			Integer Q_id,Integer M_state,
			Model model,HttpSession session) {
		// 条件查询所有员工
		User user=(User) session.getAttribute("USER_SESSION");

		if (user.getRoot()!=1) {
			Q_id=user.getId();
		}
		Page<Money> moneys=moneyService.findMoneyList(page, rows, Q_id,M_state);

		model.addAttribute("page", moneys);
		
		model.addAttribute("Q_id", Q_id);
		
		

		return "money";
	}
	
	/**
	 * 创建员工
	 */
	@RequestMapping("/money/create.action")
	@ResponseBody
	public String moneyCreate(Integer M_message,Integer R_id,Integer Q_id,Double M_take,Integer M_state,Integer M_time) {
		//money.setdata(dataStr);
		Money money=new Money();
		money.setM_message(M_message);
		money.setQ_id(Q_id);
		money.setR_id(R_id);
		money.setM_take(M_take);
		money.setM_state(M_state);
		money.settime(Help.getTime());
		//money.setM_count(m_count);
	    int rows = moneyService.createMoney(money);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	/**
	 * 通过id获取员工信息
	 */
	@RequestMapping("/money/getMoneyById.action")
	@ResponseBody
	public Money getMoneyById(Integer M_message) {
		
		Money money = moneyService.getMoneyById(M_message);
	    return money;
	}
	/**
	 * 更新员工
	 */
	@RequestMapping("/money/update.action")
	@ResponseBody
	public String moneyUpdate(Integer M_message,Integer R_id,Integer Q_id,Double M_take,Integer M_state,String M_time) {
		Money money=new Money();
		System.out.println(M_message);
		money.setM_message(M_message);
		money.setQ_id(Q_id);
		money.setR_id(R_id);
		money.setM_take(M_take);
		money.setM_state(M_state);
		money.settime(M_time);
		Double count=moneyService.getRoomPrice(R_id)*M_take;
		money.setM_count(count);
		
	    int rows = moneyService.updateMoney(money);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 删除员工
	 */
	@RequestMapping("/money/delete.action")
	@ResponseBody
	public String moneyDelete(Integer M_message) {
		
	    int rows = moneyService.deleteMoney(M_message);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	  //order
	@RequestMapping("/money/order.action")
	@ResponseBody
	public String moneyOrder(Integer M_message) {
		
	    int rows = moneyService.orderMoney(M_message);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
}
