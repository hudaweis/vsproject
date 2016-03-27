package com.vshuok.es.common.web.form;


import org.springframework.util.ObjectUtils;
import org.springframework.web.util.HtmlUtils;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public class ValueFormatter {

	 public static String getDisplayString(Object value, boolean htmlEscape) {
	        String displayValue = ObjectUtils.getDisplayString(value);
	        return (htmlEscape ? HtmlUtils.htmlEscape(displayValue) : displayValue);
	    }
}
