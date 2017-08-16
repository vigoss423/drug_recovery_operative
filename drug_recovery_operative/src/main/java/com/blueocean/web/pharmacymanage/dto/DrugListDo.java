package com.blueocean.web.pharmacymanage.dto;

import java.io.Serializable;

/**
 * 
 * @author 王欣宇
 * @time 2017年7月26日 上午11:55:55
 * @todo 
 * @remark
 */
public class DrugListDo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String goodsUpc;
	
	private String goodsName;
	
	private String primaryCategory;
	
	private String secondCategory;
	
	private String thirdCategory;
	
	private String produceEnterprise;
	
	private double drugCount;

	public String getGoodsUpc() {
		return goodsUpc;
	}

	public void setGoodsUpc(String goodsUpc) {
		this.goodsUpc = goodsUpc;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getPrimaryCategory() {
		return primaryCategory;
	}

	public void setPrimaryCategory(String primaryCategory) {
		this.primaryCategory = primaryCategory;
	}

	public String getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(String secondCategory) {
		this.secondCategory = secondCategory;
	}

	public String getThirdCategory() {
		return thirdCategory;
	}

	public void setThirdCategory(String thirdCategory) {
		this.thirdCategory = thirdCategory;
	}

	public String getProduceEnterprise() {
		return produceEnterprise;
	}

	public void setProduceEnterprise(String produceEnterprise) {
		this.produceEnterprise = produceEnterprise;
	}

	public double getDrugCount() {
		return drugCount;
	}

	public void setDrugCount(double drugCount) {
		this.drugCount = drugCount;
	}

	@Override
	public String toString() {
		return "DrugListDo [goodsUpc=" + goodsUpc + ", goodsName=" + goodsName + ", primaryCategory=" + primaryCategory
				+ ", secondCategory=" + secondCategory + ", thirdCategory=" + thirdCategory + ", produceEnterprise="
				+ produceEnterprise + ", drugCount=" + drugCount + "]";
	}


	
}
