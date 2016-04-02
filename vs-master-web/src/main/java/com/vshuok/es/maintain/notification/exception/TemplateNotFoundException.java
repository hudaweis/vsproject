package com.vshuok.es.maintain.notification.exception;


public class TemplateNotFoundException extends TemplateException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5770203427901480614L;

	public TemplateNotFoundException(String templateName) {
        super("notification.template.not.found", new Object[] {templateName});
    }
}
