package com.mezjh.dao;

import java.util.List;

import com.mezjh.entity.Customer;
import com.mezjh.entity.QueryVo;

/**
 * 客户信息持久化接口
 * 
 * @author ZJH
 *
 */
public interface CustomerDao {
	/**
	 * 查询客户信息
	 * 
	 * @return
	 */
	public List<Customer> getCustomerByQueryVo(QueryVo queryVo);

	/**
	 * 查询总记录数
	 * 
	 * @param queryVo
	 * @return
	 */
	public Integer getCountByQueryVo(QueryVo queryVo);

	/**
	 * 查询单个客户信息，用于更新客服信息
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
