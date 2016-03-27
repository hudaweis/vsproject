package com.vshuok.es.common.web.form.bind;

import javax.servlet.jsp.PageContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.support.BindStatus;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.util.HtmlUtils;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public class SearchBindStatus extends BindStatus {

    private static final String pathToUse = "___search";

    private Object value;
    private boolean htmlEscape;

    private SearchBindStatus(RequestContext requestContext, String path, boolean htmlEscape) throws IllegalStateException {
        super(requestContext, path, htmlEscape);
    }

    public static BindStatus create(PageContext pageContext, String name, RequestContext requestContext, boolean htmlEscape) {
        pageContext.getRequest().setAttribute(pathToUse, SearchModel.EMPTY);
        SearchBindStatus bindStatus = new SearchBindStatus(requestContext, pathToUse, htmlEscape);
        bindStatus.value = getValue(pageContext, name);
        bindStatus.htmlEscape = htmlEscape;
        return bindStatus;
    }

    public static Object getValue(PageContext pageContext, String name) {
		if (StringUtils.isEmpty(name)) {
            return null;
        }
        Object value = null;
        String[] parameters = pageContext.getRequest().getParameterValues(name);
        if (parameters != null && parameters.length == 1) {
            value = parameters[0];
        } else {
            value = parameters;
        }
        return value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public Object getActualValue() {
        return value;
    }

    @Override
    public String getDisplayValue() {
        if (this.value instanceof String) {
            return (String) this.value;
        }
        if (this.value != null) {
            return (this.htmlEscape ? HtmlUtils.htmlEscape(this.value.toString()) : this.value.toString());
        }
        return "";
    }

    private static class SearchModel {
        public static final SearchModel EMPTY = new SearchModel();
    }

}
