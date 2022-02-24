package com.itheima.core.service;

import com.itheima.common.utils.Page;
import com.itheima.core.po.Book;
import com.itheima.core.po.Money;
import com.itheima.core.po.Room;

public interface RoomService {
	// 查询员工列表
	public Page<Room> findRoomList(Integer page, Integer rows, 
	                           Integer R_id,Integer R_state);
	//新增员工
	public int createRoom(Room room);
	// 通过id查询员工
	public Room getRoomById(Integer R_id);
	// 更新员工
	public int updateRoom(Room room);
	// 删除员工
	public int deleteRoom(Integer R_id);
	
	public int changeRoomState(Integer id);
	public int createbook(Book book);
	public int createmoney(Money money);


}
