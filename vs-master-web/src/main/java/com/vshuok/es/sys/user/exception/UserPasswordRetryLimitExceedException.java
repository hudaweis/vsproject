package com.vshuok.es.sys.user.exception;

public class UserPasswordRetryLimitExceedException extends UserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5914162919220460611L;

	public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }
}
