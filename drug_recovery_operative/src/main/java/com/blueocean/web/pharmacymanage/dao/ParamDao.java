package com.blueocean.web.pharmacymanage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.blueocean.web.pharmacymanage.dto.Param;
import com.blueocean.web.pharmacymanage.entity.ParamDto;

@Mapper
public interface ParamDao {
	public List<Param> getForList(String type);
	/**
	 * 通过模块类型获取参数列表
	 * @param types
	 * @return
	 */
	public List<Param> getParamsByCriteria(ParamDto dto);
}
