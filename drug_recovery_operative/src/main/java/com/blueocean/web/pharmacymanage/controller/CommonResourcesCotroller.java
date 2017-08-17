package com.blueocean.web.pharmacymanage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.common.util.RetInfoUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.dto.RegionDo;
import com.blueocean.web.pharmacymanage.service.CommonResources;


@RequestMapping(value = "ResourcesAction")
@RestController
public class CommonResourcesCotroller {

	@Resource
	private CommonResources commonResources;
	
	private static Logger _log = LogManager.getLogger(CommonResourcesCotroller.class);

	/**
	 * @author zhangyalin 城市列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "listRegion")
	public RetInfo listRegion() throws Exception{
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		_log.info("开始条用城市列表");
		List<RegionDo> data = commonResources.selectRegionInfo();
		_log.info("结束条用城市列表"+data.size());
		ret.setData(data);
		return ret;
	}

}
