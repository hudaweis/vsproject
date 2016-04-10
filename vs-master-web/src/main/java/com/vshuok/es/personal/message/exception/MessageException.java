package com.vshuok.es.personal.message.exception;

import com.vshuok.es.common.exception.BaseException;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public class MessageException extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4174834205087888253L;

	public MessageException(String code, Object[] args) {
        super("personal", code, args);
    }
}
