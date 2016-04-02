package com.vshuok.es.sys.user.exception;


public class UserNotExistsException extends UserException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4008759013277149246L;

	public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
