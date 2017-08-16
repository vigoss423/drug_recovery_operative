package com.blueocean.web.pharmacymanage.service;

import java.util.List;

import com.blueocean.web.pharmacymanage.dto.RegionDo;

public interface CommonResources {
	
	/**
	 * 省市区县
	 * 
	 * @param parentId
	 * @return
	 */
	List<RegionDo> selectRegionInfo();

}
