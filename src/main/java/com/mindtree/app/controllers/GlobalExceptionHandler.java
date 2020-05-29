package com.mindtree.app.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mindtree.app.exceptions.ApplicationException;

/**
 * @author M1016253
 *
 */
@ControllerAdvice("com.mindtree.app.controllers")
public class GlobalExceptionHandler {

	public GlobalExceptionHandler() {
	}

	/**
	 * @param model
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ApplicationException.class)
	public String handleApplicationException(ModelMap model, ApplicationException ex) {
		model.put("errMsg", "Application is not responsing due to internal error.");
		return "view-error";
	}

	/**
	 * @param model
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public String handleAllException(ModelMap model, Exception ex) {
		model.put("errMsg", "This is issue occures while excuting program");
		return "view-error";
	}

}
