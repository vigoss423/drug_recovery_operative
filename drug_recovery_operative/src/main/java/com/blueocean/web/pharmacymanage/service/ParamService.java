package com.blueocean.web.pharmacymanage.service;

import java.util.List;

import com.blueocean.web.pharmacymanage.dto.Param;
import com.blueocean.web.pharmacymanage.entity.ParamDto;



public interface ParamService {

	/**
	 * 根据参数类型获取参数字典列表
	 * @param type
	 * @return
	 */
	public List<Param> getParams(ParamDto dto);
	/**
	 * 获取所有参数字典列表
	 * @return
	 */
	public List<Param> getParams();
}
