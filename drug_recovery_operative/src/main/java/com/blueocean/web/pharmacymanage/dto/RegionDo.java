package com.blueocean.web.pharmacymanage.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = {"handler"})
public class RegionDo implements Serializable{

	private String value;
	private String label;
	private List<RegionDo> children;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	public List<RegionDo> getChildren() {
		return children;
	}

	public void setChildren(List<RegionDo> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
