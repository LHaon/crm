package com.mezjh.dao;

import java.util.List;

import com.mezjh.entity.BaseDict;

/**
 * 数据字典持久化接口
 * 
 * @author ZJH
 *
 */
public interface BaseDictDao {

	/**
	 * 根据字典编码查询字典列表
	 * 
	 * @param code
	 * @return
	 */
	public List<BaseDict> getBaseDictByCode(String code);
}
