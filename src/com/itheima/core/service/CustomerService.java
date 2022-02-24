package com.itheima.core.service;
import com.itheima.common.utils.Page;
import com.itheima.core.po.User;
public interface CustomerService {
	// 查询客户列表
	public Page<User> findCustomerList(Integer page, Integer rows, 
                                        String custName,String custSource,
                                        String custIndustry,String custLevel);
	
	public int createCustomer(User customer);
	
	// 通过id查询客户
	public User getCustomerById(Integer id);
	// 更新客户
	public int updateCustomer(User customer);
	// 删除客户
	public int deleteCustomer(Integer id);

}
