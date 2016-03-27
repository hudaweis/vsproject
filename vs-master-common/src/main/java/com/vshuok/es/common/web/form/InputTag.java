/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.vshuok.es.common.web.form;

import com.vshuok.es.common.web.form.bind.SearchBindStatus;
import org.springframework.web.servlet.support.BindStatus;

import javax.servlet.jsp.JspException;

/**
 * 取值时 1、先取parameter 2、如果找不到再找attribute
 * (page--->request--->session--->application)
 */
public class InputTag extends
		org.springframework.web.servlet.tags.form.InputTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8343236187058218011L;

	private BindStatus bindStatus = null;

	@Override
	protected BindStatus getBindStatus() throws JspException {
		if (this.bindStatus == null) {
			this.bindStatus = SearchBindStatus.create(pageContext, getName(),
					getRequestContext(), false);
		}
		return this.bindStatus;
	}

	@Override
	protected String getPropertyPath() throws JspException {
		return getPath();
	}

	@Override
	public void doFinally() {
		super.doFinally();
		this.bindStatus = null;
	}

}
