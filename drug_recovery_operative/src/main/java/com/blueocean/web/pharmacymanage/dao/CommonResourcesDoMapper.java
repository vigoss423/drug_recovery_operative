package com.blueocean.web.pharmacymanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.blueocean.web.pharmacymanage.dto.RegionDo;
@Mapper
public interface CommonResourcesDoMapper {



	/**
	 * 省市区县
	 * 
	 * @param parentId
	 * @return
	 */
	List<RegionDo> selectRegionInfo(Integer parentId);

}
