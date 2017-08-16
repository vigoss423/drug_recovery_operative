package com.blueocean.web.pharmacymanage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blueocean.web.pharmacymanage.dao.CommonResourcesDoMapper;
import com.blueocean.web.pharmacymanage.dto.RegionDo;
import com.blueocean.web.pharmacymanage.service.CommonResources;


@Service
public class CommonResourcesImpl implements CommonResources {

	@Resource
	CommonResourcesDoMapper commonResourcesDoMapper;

	@Override
	public List<RegionDo> selectRegionInfo() {
		List<RegionDo> list = commonResourcesDoMapper.selectRegionInfo(1);
		return list;
	}

}
