package com.vshuok.es.sys.user.exception;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public class UserPasswordNotMatchException extends UserException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -553712482803470632L;

	public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
