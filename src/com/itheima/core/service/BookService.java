package com.itheima.core.service;


import com.itheima.common.utils.Page;
import com.itheima.core.po.Book;

public interface BookService {
	// 查询员工列表
	public Page<Book> findBookList(Integer page, Integer rows, 
	                           Integer Q_id);
	//新增员工
	public int createBook(Book book);
	// 通过id查询员工
	public Book getBookById(Integer R_id,Integer Q_id);
	// 更新员工
	public int updateBook(Book book);
	// 删除员工
	public int deleteBook(Integer R_id,Integer Q_id);
}
