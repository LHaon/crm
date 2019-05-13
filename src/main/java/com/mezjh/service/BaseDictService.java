package com.mezjh.service;

import java.util.List;

import com.mezjh.entity.BaseDict;
import com.mezjh.entity.Customer;

/**
 * 字典数据表业务逻辑接口
 * 
 * @author ZJH
 *
 */
public interface BaseDictService {

	/**
	 * 根据字典编码查询字典列表
	 * 
	 * @param code
	 * @return
	 */
	public List<BaseDict> getBaseDictByCode(String code);
}
