package com.vshuok.es.sys.user.exception;

/**
 * <p>User: Hu dawei
 * <p>Version: 1.0
 */
public class UserBlockedException extends UserException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7831465964390801087L;

	public UserBlockedException(String reason) {
        super("user.blocked", new Object[]{reason});
    }
}
