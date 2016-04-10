package com.vshuok.es.sys.user.exception;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public class UserPasswordRetryLimitExceedException extends UserException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5914162919220460611L;

	public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }
}
