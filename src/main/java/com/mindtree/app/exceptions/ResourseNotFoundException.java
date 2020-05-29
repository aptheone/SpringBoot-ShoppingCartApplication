/**
 * 
 */
package com.mindtree.app.exceptions;

/**
 * @author M1016253
 *
 */
public class ResourseNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -878508012166125899L;

	/**
	 * 
	 */
	public ResourseNotFoundException() {
	}

	/**
	 * @param message
	 */
	public ResourseNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ResourseNotFoundException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ResourseNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public ResourseNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
