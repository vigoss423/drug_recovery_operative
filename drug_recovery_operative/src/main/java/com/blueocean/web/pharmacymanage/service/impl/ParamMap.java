package com.blueocean.web.pharmacymanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.blueocean.common.util.ValidUtil;
import com.blueocean.web.pharmacymanage.dto.Param;
import com.blueocean.web.pharmacymanage.dto.ParamItem;
import com.blueocean.web.pharmacymanage.service.ParamService;

/**
 * 参数字典初始化
 * @author suchengliang
 *
 */
public class ParamMap{
	private static final Map<String, Map<String,String>> paramMap=new HashMap<String, Map<String,String>>();
	@Resource
	private ParamService paramService;
	public void init(){
		List<Param> params=paramService.getParams();
		if (!ValidUtil.isEmpty(paramMap)) {
			for (Param param : params) {
				List<ParamItem> items = param.getItems();
				if (items!=null&&!items.isEmpty()) {
					Map<String,String> item=new HashMap<String,String>();
					for (ParamItem paramItem : items) {
						item.put(paramItem.getValue(), paramItem.getName());
					}
					paramMap.put(param.getValue(), item);
				}
			}
		}
	}
	public Map<String, Map<String, String>> getParammap() {
		return paramMap;
	}
}
