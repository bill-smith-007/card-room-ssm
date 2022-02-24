package com.itheima.core.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.common.utils.Page;
import com.itheima.core.dao.BookDao;
import com.itheima.core.po.Book;
import com.itheima.core.service.BookService;


@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {
	// 声明DAO属性并注入
	@Autowired
	private BookDao bookDao;
	public Page<Book> findBookList(Integer page, Integer rows,Integer Q_id) {
		
		// 创建员工对象
        Book Book = new Book();
		// 判断员工名称
		if(StringUtils.isNotBlank(Q_id+"")){
			Book.setQ_id(Q_id);
		}
		// 判断员工工号
		
		
		// 当前页
		Book.setStart((page-1) * rows) ;
		// 每页数
		Book.setRows(rows);
		// 查询员工列表
		List<Book> Books = bookDao.selectBookList(Book);
		// 查询员工列表总记录数
		Integer count = bookDao.selectBookListCount(Book) ;
		// 创建Page返回对象
		Page<Book> result = new Page<>();
		result.setPage(page);
		result.setRows(Books);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	@Override
	public int createBook(Book Book) {
		// TODO Auto-generated method stub
		return bookDao.createBook(Book);
	}
	@Override
	public Book getBookById(@Param("Q_id")Integer Q_id,@Param("R_id")Integer R_id ) {
		// TODO Auto-generated method stub
		return bookDao.getBookById(Q_id,R_id);
	}
	@Override
	public int updateBook(Book Book) {
		// TODO Auto-generated method stub
		return bookDao.updateBook(Book);
	}
	@Override
	public int deleteBook(@Param("Q_id")Integer Q_id,@Param("R_id")Integer R_id) {
		// TODO Auto-generated method stub
		return bookDao.deleteBook(Q_id,R_id);
	}

}
