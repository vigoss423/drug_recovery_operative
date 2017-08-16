package com.blueocean.web.pharmacymanage.controller;


import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.common.constant.PharmacyConstant.YesOrNo;
import com.blueocean.common.util.RetInfoUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.entity.ParamDto;
import com.blueocean.web.pharmacymanage.service.ParamService;

/**
 * 
 * @author zhangyalin
 *
 */
@RequestMapping(value = "ParamMgr")
@RestController
public class ParamController {

	@Resource
	private ParamService paramService;

	/**
	 * 获取指定类型的参数列表
	 * 
	 * @param paramType
	 * @return
	 */
	@RequestMapping(value = "params")
	public RetInfo getParams(ParamDto dto) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		dto.setDisplay(YesOrNo.YES);
		ret.setData(paramService.getParams(dto));
		return ret;
	}

	/**
	 * 获取指定模块的参数列表
	 * 
	 * @param paramType
	 * @return
	 */
	@RequestMapping(value = "getModuleParams")
	public RetInfo getModuleParams(String[] type) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		return ret;
	}

}
