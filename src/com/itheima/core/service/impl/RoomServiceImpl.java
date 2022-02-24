package com.itheima.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.RoomDao;
import com.itheima.core.po.Book;
import com.itheima.core.po.Money;
import com.itheima.core.po.Room;
import com.itheima.core.service.RoomService;



@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {
	// 声明DAO属性并注入
	@Autowired
	private RoomDao roomDao;
	public Page<Room> findRoomList(Integer page, Integer rows,Integer R_id,Integer R_state) {
		
		// 创建员工对象
        Room Room = new Room();
		// 判断员工名称
		if(StringUtils.isNotBlank(R_id+"")){
			Room.setR_id(R_id);
		}
		// 判断员工工号
		if(StringUtils.isNotBlank(R_state+"")){
			Room.setR_state(R_state);
		}
		
		// 当前页
		Room.setStart((page-1) * rows) ;
		// 每页数
		Room.setRows(rows);
		// 查询员工列表
		List<Room> Rooms = roomDao.selectRoomList(Room);
		// 查询员工列表总记录数
		Integer count = roomDao.selectRoomListCount(Room) ;
		// 创建Page返回对象
		Page<Room> result = new Page<>();
		result.setPage(page);
		result.setRows(Rooms);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	@Override
	public int createRoom(Room Room) {
		// TODO Auto-generated method stub
		return roomDao.createRoom(Room);
	}
	@Override
	public Room getRoomById(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.getRoomById(id);
	}
	@Override
	public int updateRoom(Room Room) {
		// TODO Auto-generated method stub
		return roomDao.updateRoom(Room);
	}
	@Override
	public int deleteRoom(Integer id) {
		// TODO Auto-generated method stub
		return roomDao.deleteRoom(id);
	}
	
	@Override
	public  int changeRoomState(Integer id) {
		return roomDao.changeRoomState(id);
	}
	@Override
	public int createbook(Book book) {
		// TODO Auto-generated method stub
		return roomDao.createbook(book);
	}
	@Override
	public int createmoney(Money money) {
		// TODO Auto-generated method stub
		return roomDao.createmoney(money);
	}
}
