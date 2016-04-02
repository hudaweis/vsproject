package com.vshuok.es.sys.user.exception;

import com.vshuok.es.common.exception.BaseException;

public class UserException extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6592627475533629816L;

	public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }

}
