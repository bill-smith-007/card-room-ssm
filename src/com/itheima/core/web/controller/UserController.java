package com.itheima.core.web.controller;


import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Help;
import com.itheima.common.utils.Page;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
/**
 * 用户控制器类
 */
@Controller
public class UserController {
	// 依赖注入
	@Autowired
	private UserService userService;
	
	/**
	 * 用户登录
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.POST)
	public String login(String Q_nickname,String Q_pwd, Model model, 
                                                          HttpSession session) {
		// 通过账号和密码查询用户
		User user = userService.findUser(Q_nickname, Q_pwd);
		
		if(user != null){		
			// 将用户对象添加到Session
			Help.local_user=user;
			
			
			session.setAttribute("USER_SESSION", user);
			// 跳转到主页面
//			return "customer";
			return "redirect:room/list.action";
		}
		model.addAttribute("msg", "账号或密码错误，请重新输入！");
         // 返回到登录页面
		return "login";
	}
	
	/**
	 * 模拟其他类中跳转到客户管理页面的方法
	 */
	@RequestMapping(value = "/toCustomer.action")
	public String toCustomer() {
	    return "customer";
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping(value = "/logout.action")
	public String logout(HttpSession session) {
	    // 清除Session
	    session.invalidate();
	    // 重定向到登录页面的跳转方法
	    return "redirect:login.action";
	}
	/**
	 * 向用户登陆页面跳转
	 */
	@RequestMapping(value = "/login.action", method = RequestMethod.GET)
	public String toLogin() {
	    return "login";
	}
	
	@RequestMapping(value = "/user/list.action")
	public String list(@RequestParam(defaultValue="1")Integer page,
			@RequestParam(defaultValue="10")Integer rows, 
			String Q_nickname, String Q_root, Model model) {
		// 条件查询所有客户
		//System.out.println(Q_root);
		Page<User> user = userService
				.findUserList(page, rows,Q_nickname,Q_root);
		model.addAttribute("page", user);
		// 客户来源
		
		// 添加参数
		model.addAttribute("Q_nickname", Q_nickname);
		model.addAttribute("Q_root", Q_root);
		//System.out.println(Q_root);
		return "user";
		
	}
	@RequestMapping("/user/create.action")
	@ResponseBody
	public String customerCreate(String Q_nickname,String Q_pwd,String Q_root,String Q_introduce,String Q_phone,String Q_sex,String Q_data) {
		User user=new User();
		user.setNickname(Q_nickname);
		user.setPassword(Q_pwd);
		user.setRoot(Q_root=="管理"?1:0);
		user.setIntroduce(Q_introduce);
		user.setPhone(Q_phone);
		user.setSex(Q_sex=="男"?1:0);
		user.setData(Q_data);
		//System.out.println(staff);
	    int rows = userService.createUser(user);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}
	@RequestMapping("/user/update.action")
	@ResponseBody
	public String userUpdate(int id,String Q_nickname,String Q_pwd,int Q_root,String Q_introduce,String Q_phone,int Q_sex,String Q_data) {
		User user=new User();
		user.setNickname(Q_nickname);
		user.setPassword(Q_pwd);
		user.setRoot(Q_root);
		user.setIntroduce(Q_introduce);
		user.setPhone(Q_phone);
		user.setSex(Q_sex);
		user.setData(Q_data);
		user.setId(id);
	    int rows = userService.updateUser(user);
	    if(rows > 0){
	        return "OK";
	    }else{
	        return "FAIL";
	    }
	}

	/**
	 * 删除客户
	 */
	@RequestMapping("/user/delete.action")
	@ResponseBody
	public String userDelete(Integer id) {
	    int rows = userService.deleteUser(id);
	    if(rows > 0){			
	        return "OK";
	    }else{
	        return "FAIL";			
	    }
	}
	/**
	 * 通过id获取客户信息
	 */
	@RequestMapping("/user/getUserById.action")
	@ResponseBody
	public User getUserById(Integer id) {
	    User user = userService.getUserById(id);
	    return user;
	}

}
