package com.blueocean.web.pharmacymanage.entity;

import java.util.List;

import com.blueocean.web.pharmacymanage.dto.DrugOrderListDo;


public class DrugOrderListResponseDTO {
	
	private Long totalCount = 0L;
	
	private List<DrugOrderListDo> drugOrderList;

	
	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public List<DrugOrderListDo> getDrugOrderList() {
		return drugOrderList;
	}

	public void setDrugOrderList(List<DrugOrderListDo> drugOrderList) {
		this.drugOrderList = drugOrderList;
	}

	@Override
	public String toString() {
		return "DrugOrderListResponseDTO [totalCount=" + totalCount + ", drugOrderList=" + drugOrderList + "]";
	}
	
}
