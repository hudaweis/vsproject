package com.vshuok.es.sys.user.exception;


/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public class UserNotExistsException extends UserException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4008759013277149246L;

	public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
