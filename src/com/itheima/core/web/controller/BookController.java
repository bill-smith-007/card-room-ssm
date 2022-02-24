package com.itheima.core.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Help;
import com.itheima.common.utils.Page;
import com.itheima.core.po.Book;
import com.itheima.core.po.User;
import com.itheima.core.service.BookService;

@Controller
public class BookController {
	// 依赖注入
	@Autowired
	private BookService bookService;
	
	/**
	 *  员工列表
	 */
	@RequestMapping(value = "/book/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			Integer Q_id,
			Model model ,HttpSession session) {
		// 条件查询所有员工
		User user=(User) session.getAttribute("USER_SESSION");
		if (user.getRoot()!=1) {
			Q_id=user.getId();
		}
		Page<Book> books=bookService.findBookList(page, rows, Q_id);

		model.addAttribute("page", books);
		
		model.addAttribute("Q_id", Q_id);
		
		

		return "book";
	}
	
	/**
	 * 创建员工
	 */
	@RequestMapping("/book/create.action")
	@ResponseBody
	public String bookCreate(Double take,String R_data,Integer R_id) {
		//book.setdata(dataStr);
		Book book=new Book();
		book.setB_take(take);
		book.settime(R_data);
		book.setQ_id(Help.local_user.getId());
		book.setR_id(R_id);
		book.setcreate(Help.getTime());
	    int rows = bookService.createBook(book);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	/**
	 * 通过id获取员工信息
	 */
	@RequestMapping("/book/getBookById.action")
	@ResponseBody
	public Book getBookById(@Param("Q_id")Integer Q_id,@Param("R_id")Integer R_id) {
		
		Book book = bookService.getBookById(Q_id,R_id);
	    return book;
	}
	/**
	 * 更新员工
	 */
	@RequestMapping("/book/update.action")
	@ResponseBody
	public String bookUpdate(Integer R_id,Integer Q_id, Double take,String B_time) {
		Book book=new Book();
		book.setB_take(take);
		book.settime(B_time);
		book.setQ_id(Q_id);
		book.setR_id(R_id);
		book.setcreate(Help.getTime());
	    int rows = bookService.updateBook(book);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	
	/**
	 * 删除员工
	 */
	@RequestMapping("/book/delete.action")
	@ResponseBody
	public String bookDelete(@Param("Q_id")Integer Q_id,@Param("R_id")Integer R_id) {
		System.out.println(Q_id);
	    int rows = bookService.deleteBook(Q_id,R_id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	   
}
