package com.blueocean.web.pharmacymanage.service;


import com.blueocean.common.vo.RetInfo;
import com.blueocean.web.pharmacymanage.dto.DrugOrderDetailDo;
import com.blueocean.web.pharmacymanage.entity.DrugOrderRequestDTO;


public interface DrugOrderInfo {

	RetInfo listDrugOrderService(DrugOrderRequestDTO record);

	DrugOrderDetailDo queryDrugOrderDeatilService(DrugOrderRequestDTO record);
	

}
