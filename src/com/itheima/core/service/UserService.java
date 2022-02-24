package com.itheima.core.service;
import com.itheima.common.utils.Page;
import com.itheima.core.po.User;
/**
 * 用户Service层接口
 */
public interface UserService {
	// 通过账号和密码查询用户
	public User findUser(String Q_nickname,String Q_pwd);
	public Page<User> findUserList(Integer page, Integer rows, 
            String Q_nickname,String Q_root);
		// TODO Auto-generated method stub
	public User getUserById(Integer id);

	public int createUser(User user);
	public int updateUser(User user);
	// 删除客户
	public int deleteUser(Integer id);

}
