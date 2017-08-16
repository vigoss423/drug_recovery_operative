package com.blueocean.web.pharmacymanage.dto;


public class ValidateUser {
	private boolean isValidate;
	private String message;
	private DrugRecycleSiteDo userdto;
	public DrugRecycleSiteDo getUserdto() {
		return userdto;
	}
	public void setUserdto(DrugRecycleSiteDo userdto) {
		this.userdto = userdto;
	}
	public boolean isValidate() {
		return isValidate;
	}
	public void setValidate(boolean isValidate) {
		this.isValidate = isValidate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ValidateUser(boolean isValidate, String message) {
		this.isValidate = isValidate;
		this.message = message;
	}
	public ValidateUser() {
		
		// TODO Auto-generated constructor stub
	}
	
}
