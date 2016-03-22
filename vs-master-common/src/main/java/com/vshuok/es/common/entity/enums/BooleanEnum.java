package com.vshuok.es.common.entity.enums;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public enum BooleanEnum {

	TRUE(Boolean.TRUE, "是"), FALSE(Boolean.FALSE, "否");

	private final Boolean value;
	private final String info;

	private BooleanEnum(Boolean value, String info) {
		this.value = value;
		this.info = info;
	}
	
	public String getInfo(){
		return info;
	}
	
	public Boolean getValue(){
		return value;
	}
}
