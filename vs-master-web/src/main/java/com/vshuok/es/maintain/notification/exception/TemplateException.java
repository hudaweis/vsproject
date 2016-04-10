package com.vshuok.es.maintain.notification.exception;

import com.vshuok.es.common.exception.BaseException;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public class TemplateException extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2374313627497590022L;

	public TemplateException(final String code, final Object[] args) {
        super("notification", code, args);
    }
}
