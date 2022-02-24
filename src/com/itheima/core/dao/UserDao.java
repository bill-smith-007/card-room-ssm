package com.itheima.core.dao;
import org.apache.ibatis.annotations.Param;

import com.itheima.core.po.User;
import java.util.List;
/**
 * 用户DAO层接口
 */
public interface UserDao {
	/**
	 * 通过账号和密码查询用户
	 */
	public User findUser(@Param("Q_nickname") String Q_nickname,
			                @Param("Q_pwd") String Q_pwd);
	
	public  List<User> selectUserList(User user);
	// 客户数
	public Integer selectUserListCount(User user);
	public User getUserById(Integer id);

	public int createUser(User user);
	public int updateUser(User user);
	// 删除客户
	int deleteUser (Integer id);

	
}
