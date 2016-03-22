package com.vshuok.es.common.entity.search.exception;

import org.springframework.core.NestedRuntimeException;

/**
 * 
 * @author Hu Dawei
 * @version 1.0
 * @Date：2016年3月22日 下午3:00:16
 */
public class SearchException extends NestedRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8194274292208672064L;

	public SearchException(String msg) {
		super(msg);
	}

	public SearchException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
