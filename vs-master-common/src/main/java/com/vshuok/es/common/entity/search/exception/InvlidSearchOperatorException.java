package com.vshuok.es.common.entity.search.exception;

import com.vshuok.es.common.entity.search.SearchOperator;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public final class InvlidSearchOperatorException extends SearchException {

	   /**
	 * 
	 */
	private static final long serialVersionUID = -1468654944712608006L;

	public InvlidSearchOperatorException(String searchProperty, String operatorStr) {
	        this(searchProperty, operatorStr, null);
	    }

	    public InvlidSearchOperatorException(String searchProperty, String operatorStr, Throwable cause) {
	        super("Invalid Search Operator searchProperty [" + searchProperty + "], " +
	                "operator [" + operatorStr + "], must be one of " + SearchOperator.toStringAllOperator(), cause);
	    }
}
