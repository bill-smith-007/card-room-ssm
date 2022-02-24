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
import com.itheima.core.po.Book;
import com.itheima.core.po.Money;
import com.itheima.core.po.Room;
import com.itheima.core.po.User;
import com.itheima.core.service.RoomService;

@Controller
public class RoomController {
	// 依赖注入
	@Autowired
	private RoomService roomService;
	
	/**
	 *  员工列表
	 */
	@RequestMapping(value = "/room/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			Integer R_id,Integer R_state,
			Model model) {
		// 条件查询所有员工
		Page<Room> rooms=roomService.findRoomList(page, rows, R_id,R_state );

		model.addAttribute("page", rooms);
		
		model.addAttribute("R_id", R_id);
		model.addAttribute("R_state", R_state);
		

		return "room";
	}
	
	/**
	 * 创建员工
	 */
	@RequestMapping("/room/create.action")
	@ResponseBody
	public String customerCreate(String R_class,String R_introduce,Integer R_state,Integer R_price,String R_data) {
		//room.setdata(dataStr);
		Room room=new Room();
		room.setR_class(R_class);
		room.setR_introduce(R_introduce);
		room.setR_state(R_state);
		room.setR_price(R_price);
		room.setdata(R_data);
		System.out.println(room);
	    int rows = roomService.createRoom(room);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	/**
	 * 通过id获取员工信息
	 */
	@RequestMapping("/room/getRoomById.action")
	@ResponseBody
	public Room getRoomById(Integer id) {
		Room room = roomService.getRoomById(id);
	    return room;
	}
	/**
	 * 更新员工
	 */
	@RequestMapping("/room/update.action")
	@ResponseBody
	public String roomUpdate(Integer R_id, String R_class,String R_introduce,Integer R_state,Integer R_price,String R_data) {
		Room room=new Room();
		room.setR_class(R_class);
		room.setR_introduce(R_introduce);
		room.setR_state(R_state);
		room.setR_price(R_price);
		room.setdata(R_data);
		room.setR_id(R_id);
	    int rows = roomService.updateRoom(room);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 删除员工
	 */
	@RequestMapping("/room/delete.action")
	@ResponseBody
	public String roomDelete(Integer id) {
	    int rows = roomService.deleteRoom(id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	@RequestMapping("/room/newBook.action")
	@ResponseBody
	public String roomBook(Integer R_id,Integer R_price,String B_data,Integer B_time, HttpSession session) {
		String result="";
		User user=(User) session.getAttribute("USER_SESSION");
		
	    Book book=new Book();
	    book.setR_id(R_id);
	    //System.out.println(Help.local_user.getId());
	    book.setQ_id(user.getId());
	    book.setB_take(Double.valueOf(B_time));
	    book.settime(B_data);
	    book.setcreate(Help.getTime());
	    
	    Money money=new Money();
	    money.setQ_id(user.getId());
	    money.setM_count(Double.valueOf(R_price*B_time));
	    money.setR_id(R_id);
	    money.setM_state(0);
	    money.settime(Help.getTime());
		int rows_test = roomService.changeRoomState(R_id);
	    if(rows_test > 0){
	    	 int rows_step1 = roomService.createbook(book);
	    	 if(rows_step1 > 0){
	    		 int rows_step2 = roomService.createmoney(money);
	    		 if(rows_step2 > 0)  {result= "OK";};	
	    	 }
	        
	    }else{
	    	result= "FAIL";			
	    }
		return result;
		
	}
	   
}
