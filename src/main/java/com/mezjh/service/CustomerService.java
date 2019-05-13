package com.mezjh.service;

import com.mezjh.entity.Customer;
import com.mezjh.entity.QueryVo;
import com.mezjh.utils.Page;

/**
 * 客户业务逻辑接口
 * 
 * @author ZJH
 *
 */
public interface CustomerService {
	/**
	 * 查询客户信息
	 * 
	 * @return
	 */
	public Page<Customer> getCustomerByQueryVo(QueryVo queryVo);

	/**
	 * 通过客户ID查找客户
	 * 
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(Integer id);

	/**
	 * 更新客户信息
	 * 
	 * @param customer
	 */
	public void updateCustomer(Customer customer);

	/**
	 * 删除客户
	 * 
	 * @param id
	 */
	public void deleteCustomerById(Integer id);
}
