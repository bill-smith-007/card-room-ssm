package com.itheima.core.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import com.itheima.common.utils.Page;
import com.itheima.core.dao.UserDao;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
/**
 * 用户Service接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	// 注入UserDao
	@Autowired
	private UserDao userDao;
	// 通过账号和密码查询用户
	@Override
	public User findUser(String usercode, String password) {
		User user = this.userDao.findUser(usercode, password);
		return user;
	}
	
	@Override
	public int createUser(User user) {
	    return userDao.createUser(user);
	}

	@Override
	public Page<User> findUserList(Integer page, Integer rows, String Q_nickname, String Q_root) {
		// TODO Auto-generated method stub
		User user=new User();
		if(StringUtils.isNotBlank(Q_nickname)){
			user.setNickname(Q_nickname);
			//System.out.println(Q_nickname);
		}
		// 判断客户信息来源
		if(StringUtils.isNotBlank(Q_root)){
			user.setRoot(Integer.parseInt(Q_root));
		}
		// 当前页
		user.setStart((page-1) * rows) ;
		// 每页数
		user.setRows(rows);
		//System.out.println(user.getRoot());
		// 查询客户列表
		List<User> users = userDao.selectUserList(user);
		// 查询客户列表总记录数
		Integer count = userDao.selectUserListCount(user);
		// 创建Page返回对象
		Page<User> result = new Page<>();
		
		result.setPage(page);
		result.setRows(users);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		// TODO Auto-generated method stub
		  return userDao.deleteUser(id);	
	}
	/**
	 * 通过id查询客户
	 */
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		 User user = userDao.getUserById(id);
		    return user;
	}
}
