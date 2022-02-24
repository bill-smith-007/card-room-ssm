package com.itheima.core.dao;

import java.util.List;

import com.itheima.core.po.Book;
import com.itheima.core.po.Money;
import com.itheima.core.po.Room;


public interface RoomDao {
	public List<Room> selectRoomList(Room room);
	// 房间数
	public Integer selectRoomListCount(Room room);
	// 创建房间
	public int createRoom(Room room);
	// 通过id查询房间
	public Room getRoomById(Integer id);
	// 更新房间信息
	public int updateRoom(Room room);
	// 删除房间
	int deleteRoom (Integer id);
	
	//selectRoomPrice
	public int changeRoomState(Integer id);
	//createbook
	public int createbook(Book book);
	//createmoney
	public int createmoney(Money money);
}
