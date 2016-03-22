package com.vshuok.es.common.entity.search.exception;
/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public final class InvalidSearchPropertyException extends SearchException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5150883748799772293L;
	
	public InvalidSearchPropertyException(String searchProperty, String entityProperty) {
        this(searchProperty, entityProperty, null);
    }

    public InvalidSearchPropertyException(String searchProperty, String entityProperty, Throwable cause) {
        super("Invalid Search Property [" + searchProperty + "] Entity Property [" + entityProperty + "]", cause);
    }

}
