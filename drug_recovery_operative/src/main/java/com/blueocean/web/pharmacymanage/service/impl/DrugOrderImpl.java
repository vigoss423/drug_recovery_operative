package com.blueocean.web.pharmacymanage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.blueocean.common.constant.RetInfoConstant;
import com.blueocean.common.util.RetInfoUtil;
import com.blueocean.common.util.StringUtil;
import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.dao.DrugOrderDoMapper;
import com.blueocean.web.pharmacymanage.dto.DrugListDo;
import com.blueocean.web.pharmacymanage.dto.DrugOrderDetailDo;
import com.blueocean.web.pharmacymanage.dto.DrugOrderListDo;
import com.blueocean.web.pharmacymanage.entity.DrugOrderRequestDTO;
import com.blueocean.web.pharmacymanage.service.DrugOrderInfo;
import com.blueocean.web.pharmacymanage.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 
 * @author 王欣宇
 * @time 2017年7月26日 上午10:01:19
 * @todo
 * @remark
 */
@Service
public class DrugOrderImpl implements DrugOrderInfo {

	@Resource
	private DrugOrderDoMapper drugOrderDoMapper;
	@Resource
	private IUserService userService;

	@Override
	public RetInfo listDrugOrderService(DrugOrderRequestDTO record) {
		Map<String, Object> params = checkParams(record);
		PageHelper.startPage(record.getPage(), record.getPageSize());
		List<DrugOrderListDo> orderLst = drugOrderDoMapper.listDrugOrderByParams(params);
		// 获取总数
		Page<DrugOrderListDo> listCountry = (Page<DrugOrderListDo>) orderLst;
		Long count = listCountry.getTotal();
		RetInfo ret = installDrugOrderResult(orderLst, count);
		return ret;
	}

	private RetInfo installDrugOrderResult(List<DrugOrderListDo> orderLst, Long count) {
		RetInfo ret = RetInfoUtil.initRetInfo4Succ();
		if (!StringUtil.isNullOrEmpty(orderLst)) {
			ret.setData(orderLst);
		}
		ret.setTotal(count);
		return ret;
	}

	@Override
	public DrugOrderDetailDo queryDrugOrderDeatilService(DrugOrderRequestDTO record) {
		String orderId = record.getOrderId();
		DrugOrderDetailDo order = drugOrderDoMapper.selectDrugOrderDetail(orderId);
		if (StringUtil.isNullOrEmpty(order)) {
			throw new RuntimeException(RetInfoConstant.RETMSG_ORDER_NOT_EXIST);
		}
		String orderStatus = order.getOrderStatus();
		if (orderStatus.equals("已完成")) {
			List<DrugListDo> drugLst = drugOrderDoMapper.selectDrugInfoByOrderId(orderId);
			if (!StringUtil.isNullOrEmpty(drugLst)) {
				order.setDrugLst(drugLst);
			}
		}
		return order;
	}

	/**
	 * 
	 * @param record
	 * @return
	 */
	private Map<String, Object> checkParams(DrugOrderRequestDTO record) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		String orderId = record.getOrderId();
		String orderStartTime = record.getOrderStartTime();
		String orderEndTime = record.getOrderEndTime();
		String userPhone = record.getUserPhone();
		String drugSiteName = record.getDrugSiteName();
		Integer orderType = record.getOrderType();
		Integer orderStatus = record.getOrderStatus();

		if (!StringUtil.isNull(orderId)) {
			paramsMap.put("orderId", orderId);
		}
		if (!StringUtil.isNull(orderStartTime)) {
			paramsMap.put("orderStartTime", orderStartTime);
		}
		if (!StringUtil.isNull(orderEndTime)) {
			paramsMap.put("orderEndTime", orderEndTime);
		}
		if (!StringUtil.isNull(userPhone)) {
			paramsMap.put("userPhone", userPhone);
		}
		if (!StringUtil.isNull(drugSiteName)) {
			paramsMap.put("drugSiteName", drugSiteName);
		}
		if (null != orderType) {
			paramsMap.put("orderType", orderType.toString());
		}
		if (null != orderStatus) {
			paramsMap.put("orderStatus", orderStatus.toString());
		}
		return paramsMap;

	}
}
