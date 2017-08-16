package com.blueocean.web.pharmacymanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blueocean.web.pharmacymanage.dao.ParamDao;
import com.blueocean.web.pharmacymanage.dto.Param;
import com.blueocean.web.pharmacymanage.entity.ParamDto;
import com.blueocean.web.pharmacymanage.service.ParamService;


@Service
public class ParamServiceImpl implements ParamService {

	@Resource
	private ParamDao paramDao;

	@Override
	public List<Param> getParams(ParamDto dto) {
		return paramDao.getParamsByCriteria(dto);
	}

	@Override
	public List<Param> getParams() {
		return getParams(null);
	}
}
