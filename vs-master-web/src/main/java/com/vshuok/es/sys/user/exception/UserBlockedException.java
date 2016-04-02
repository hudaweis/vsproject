package com.vshuok.es.sys.user.exception;


public class UserBlockedException extends UserException {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7831465964390801087L;

	public UserBlockedException(String reason) {
        super("user.blocked", new Object[]{reason});
    }
}
