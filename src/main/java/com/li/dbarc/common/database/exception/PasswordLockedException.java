package com.li.dbarc.common.database.exception;

import org.springframework.security.authentication.AccountStatusException;

public class PasswordLockedException extends AccountStatusException{
	 /**
	 * 
	 */
	private static final long serialVersionUID = -4102944954687486332L;

	//~ Constructors ===================================================================================================

    /**
	 * 
	 */

	/**
     * Constructs a <code>LockedException</code> with the specified message.
     *
     * @param msg the detail message.
     */
    public PasswordLockedException(String msg) {
        super(msg);
    }

    /**
     * Constructs a <code>LockedException</code> with the specified message and
     * root cause.
     *
     * @param msg the detail message.
     * @param t root cause
     */
    public PasswordLockedException(String msg, Throwable t) {
        super(msg, t);
    }
}
