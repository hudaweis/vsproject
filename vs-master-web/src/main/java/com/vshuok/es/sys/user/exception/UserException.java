package com.vshuok.es.sys.user.exception;

import com.vshuok.es.common.exception.BaseException;

/**
 * <p>User: Hu dawei
 * <p>Version: 1.0
 */
public class UserException extends BaseException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6592627475533629816L;

	public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }

}
