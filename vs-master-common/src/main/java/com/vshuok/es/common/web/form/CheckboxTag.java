package com.vshuok.es.common.web.form;

import javax.servlet.jsp.JspException;

import org.springframework.web.servlet.support.BindStatus;

import com.vshuok.es.common.web.form.bind.SearchBindStatus;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public class CheckboxTag extends org.springframework.web.servlet.tags.form.CheckboxTag {

	  /**
	 * 
	 */
	private static final long serialVersionUID = -2372775208940798058L;
	
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
