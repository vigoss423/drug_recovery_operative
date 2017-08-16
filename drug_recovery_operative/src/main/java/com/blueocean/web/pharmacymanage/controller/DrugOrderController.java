package com.blueocean.web.pharmacymanage.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blueocean.common.util.RetInfoUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.dto.DrugOrderDetailDo;
import com.blueocean.web.pharmacymanage.entity.DrugOrderRequestDTO;
import com.blueocean.web.pharmacymanage.service.DrugOrderInfo;
import com.blueocean.web.pharmacymanage.service.PharmacyManageInfo;


/**
 * 
 * @author 王欣宇
 * @time 2017年7月26日 上午9:52:13
 * @todo 运营端订单管理
 * @remark
 */
@RequestMapping(value = "DrugOrderAction")
@RestController
public class DrugOrderController {

	@Resource
	private DrugOrderInfo drugOrderInfo;
	@Resource
	private PharmacyManageInfo pharmacyManageInfo;

	@RequestMapping(value = "listDrugOrder")
	public RetInfo listDrugOrder(@RequestBody DrugOrderRequestDTO record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		ret = drugOrderInfo.listDrugOrderService(record);
		return ret;
	}

	@RequestMapping(value = "queryDrugOrderDetail")
	public RetInfo queryDrugOrderDetail(@RequestBody DrugOrderRequestDTO record) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		DrugOrderDetailDo order = drugOrderInfo.queryDrugOrderDeatilService(record);
		ret.setData(order);
		return ret;
	}


}
