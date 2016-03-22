package com.vshuok.es.common.entity.enums;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public enum AvailableEnum {

	TRUE(Boolean.TRUE, "可用"), FALSE(Boolean.FALSE, "不可用");

	private final Boolean value;
	private final String info;

	private AvailableEnum(Boolean value, String info) {
		this.value = value;
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public Boolean getValue() {
		return value;
	}
}
