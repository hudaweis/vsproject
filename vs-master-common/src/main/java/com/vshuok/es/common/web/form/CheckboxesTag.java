package com.vshuok.es.common.web.form;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.support.BindStatus;

import com.vshuok.es.common.web.form.bind.SearchBindStatus;


/** 
 * 取值时
 * 1、先取parameter
 * 2、如果找不到再找attribute (page--->request--->session--->application)
 * @author Hu Dawei  
 * @version 1.0
 */
public class CheckboxesTag extends org.springframework.web.servlet.tags.form.CheckboxesTag {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 3836869858083961981L;
	
	private BindStatus bindStatus = null;

	    @Override
	    protected BindStatus getBindStatus() throws JspException {
	        if (this.bindStatus == null) {
	            this.bindStatus = SearchBindStatus.create(pageContext, getName(), getRequestContext(), false);
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
