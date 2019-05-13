package com.mezjh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mezjh.dao.CustomerDao;
import com.mezjh.entity.Customer;
import com.mezjh.entity.QueryVo;
import com.mezjh.service.CustomerService;
import com.mezjh.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Page<Customer> getCustomerByQueryVo(QueryVo queryVo) {

		// 计算分页查询从哪条记录开始
		queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());

		// 查询总记录数
		Integer total = customerDao.getCountByQueryVo(queryVo);

		// 查询每页的数据列表
		List<Customer> list = customerDao.getCustomerByQueryVo(queryVo);

		// 包装分页数据
		Page<Customer> page = new Page<Customer>(total, queryVo.getPage(), queryVo.getRows(), list);

		return page;
	}

	@Override
	public Customer getCustomerById(Integer id) {
		return customerDao.getCustomerById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
	}

	@Override
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
	}

}
