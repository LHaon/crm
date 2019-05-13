package com.mezjh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mezjh.dao.BaseDictDao;
import com.mezjh.entity.BaseDict;
import com.mezjh.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao baseDictDao;

	@Override
	public List<BaseDict> getBaseDictByCode(String code) {
		return baseDictDao.getBaseDictByCode(code);
	}

}
