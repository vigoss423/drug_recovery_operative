package com.blueocean.web.pharmacymanage.entity;

public class DrugOrderRequestDTO {
	
	private String orderId;
	
	private String orderStartTime;
	
	private String orderEndTime;
	
	private String userPhone;
	
	private String DrugSiteName;
	
	private Integer orderType;
	
	private Integer orderStatus;
	// 每页条数(默认10)
	private int PageSize = 10;
	// 页数(默认1)
	private int page = 1;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderStartTime() {
		return orderStartTime;
	}
	public void setOrderStartTime(String orderStartTime) {
		this.orderStartTime = orderStartTime;
	}
	public String getOrderEndTime() {
		return orderEndTime;
	}
	public void setOrderEndTime(String orderEndTime) {
		this.orderEndTime = orderEndTime;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getDrugSiteName() {
		return DrugSiteName;
	}
	public void setDrugSiteName(String drugSiteName) {
		DrugSiteName = drugSiteName;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	@Override
	public String toString() {
		return "DrugOrderRequestDTO [orderId=" + orderId + ", orderStartTime=" + orderStartTime + ", orderEndTime="
				+ orderEndTime + ", userPhone=" + userPhone + ", DrugSiteName=" + DrugSiteName + ", orderType="
				+ orderType + ", orderStatus=" + orderStatus + ", PageSize=" + PageSize + ", page=" + page + "]";
	}
	
}
