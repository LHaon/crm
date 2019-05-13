package com.mezjh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mezjh.entity.BaseDict;
import com.mezjh.entity.Customer;
import com.mezjh.entity.QueryVo;
import com.mezjh.service.BaseDictService;
import com.mezjh.service.CustomerService;
import com.mezjh.utils.Page;

/**
 * 
 * @author ZJH
 *
 */

@Controller
@RequestMapping("customer")
public class CustomerController {

	// 属性注入
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;

	@Value("${customer_from_type}")
	private String customer_from_type;

	@Value("${customer_industry_type}")
	private String customer_industry_type;

	@Value("${customer_level_type}")
	private String customer_level_type;

	@RequestMapping("list")
	public String list(Model model, QueryVo queryVo) {

		// 查询来源
		List<BaseDict> fromType = baseDictService.getBaseDictByCode(customer_from_type);
		// 查询行业
		List<BaseDict> industryType = baseDictService.getBaseDictByCode(customer_industry_type);
		// 查询级别
		List<BaseDict> levelType = baseDictService.getBaseDictByCode(customer_level_type);

		// 设置数据模型返回
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		// 跟据查询条件分页查询用户列表
		Page<Customer> page = customerService.getCustomerByQueryVo(queryVo);

		// 设置分页数返回
		model.addAttribute("page", page);

		// 返回查询条件
		model.addAttribute("vo", queryVo);

		return "customer";
	}

	@RequestMapping("edit")
	@ResponseBody
	public Customer edit(Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}

	@RequestMapping("update")
	@ResponseBody
	public String update(Customer customer) {
		String msg = "1";
		try {
			customerService.updateCustomer(customer);
			msg = "0";
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return msg;
	}

	@RequestMapping("delete")
	@ResponseBody
	public String delete(Integer id) {
		String msg = "1";
		try {
			customerService.deleteCustomerById(id);
			msg = "0";
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return msg;
	}
}
