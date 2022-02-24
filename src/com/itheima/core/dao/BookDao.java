package com.itheima.core.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.Book;


public interface BookDao {
	public List<Book> selectBookList(Book book);
	// 房间数
	public Integer selectBookListCount(Book book);
	// 创建房间
	public int createBook(Book book);
	// 通过id查询房间
	public Book getBookById(@Param("Q_id")Integer Q_id,@Param("R_id")Integer R_id);
	// 更新房间信息
	public int updateBook(Book book);
	// 删除房间
	int deleteBook(@Param("Q_id")Integer Q_id,@Param("R_id")Integer R_id);
}
