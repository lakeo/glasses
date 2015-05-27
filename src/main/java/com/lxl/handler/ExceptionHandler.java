package com.lxl.handler;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.base.Throwables;

/**
 * General error handler for the application.
 */
@ControllerAdvice
class ExceptionHandler {
	Logger logger = Logger.getLogger(ExceptionHandler.class);
	/**
	 * Handle exceptions thrown by handlers.
	 */
	@org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
	public ModelAndView exception(Exception exception, WebRequest request) {
		logger.warn(exception);
		ModelAndView modelAndView = new ModelAndView("/error/general");
		modelAndView.addObject("errorMessage", Throwables.getRootCause(exception));
		return modelAndView;
	}
}