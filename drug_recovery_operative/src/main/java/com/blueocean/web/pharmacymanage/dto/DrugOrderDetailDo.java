package com.blueocean.web.pharmacymanage.dto;

import java.io.Serializable;
import java.util.List;

public class DrugOrderDetailDo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderId;
	
	private String orderType;
	
	private String orderStatus;
	
	private String orderPhone;
	
	private String orderAddr;
	
	private String drugRecycleSiteName;
	
	private Integer recycleCount;
	
	private Double cashCoupon;
	 
	private String orderTime;
	
	private List<DrugListDo> drugLst;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderType() {
		if(orderType.equals("0")){
			orderType="自送";
		}else if(orderType.equals("1")){
			orderType="上门";
		}
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getDrugRecycleSiteName() {
		return drugRecycleSiteName;
	}

	public void setDrugRecycleSiteName(String drugRecycleSiteName) {
		this.drugRecycleSiteName = drugRecycleSiteName;
	}

	public Integer getRecycleCount() {
		return recycleCount;
	}

	public void setRecycleCount(Integer recycleCount) {
		this.recycleCount = recycleCount;
	}

	public Double getCashCoupon() {
		return cashCoupon;
	}

	public void setCashCoupon(Double cashCoupon) {
		this.cashCoupon = cashCoupon;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public List<DrugListDo> getDrugLst() {
		return drugLst;
	}

	public void setDrugLst(List<DrugListDo> drugLst) {
		this.drugLst = drugLst;
	}
	
	

	public String getOrderStatus() {
		if(orderStatus.equals("0")){
			orderStatus="待回收";
		}else if(orderStatus.equals("1")){
			orderStatus="已完成";
		}else if(orderStatus.equals("2")){
			orderStatus="已关闭";
		}
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "DrugOrderDetailDo [orderId=" + orderId + ", orderType=" + orderType + ", orderStatus=" + orderStatus
				+ ", orderPhone=" + orderPhone + ", orderAddr=" + orderAddr + ", drugRecycleSiteName="
				+ drugRecycleSiteName + ", recycleCount=" + recycleCount + ", cashCoupon=" + cashCoupon + ", orderTime="
				+ orderTime + ", drugLst=" + drugLst + "]";
	}

	
	

}
