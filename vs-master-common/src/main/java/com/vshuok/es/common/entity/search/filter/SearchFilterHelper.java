package com.vshuok.es.common.entity.search.filter;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import com.vshuok.es.common.entity.search.SearchOperator;
import com.vshuok.es.common.entity.search.exception.SearchException;

/**
 * @author Hu Dawei
 * @version 1.0
 */
public final class SearchFilterHelper {

	/**
	 * 根据插叙key和值生成Condition
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws SearchException
	 */
	public static SearchFilter newCondition(final String key, final Object value)
			throws SearchException {
		return Condition.newCondition(key, value);
	}

	/**
	 * 根据查询属性、操作符和值生成Condition
	 * 
	 * @param searchProperty
	 * @param operator
	 * @param value
	 * @return
	 */
	public static SearchFilter newCondition(final String searchProperty,
			final SearchOperator operator, final Object value) {
		return Condition.newCondition(searchProperty, operator, value);
	}

	/**
	 * 拼 or 条件
	 * 
	 * @param first
	 * @param others
	 * @return
	 */
	public static SearchFilter or(SearchFilter first, SearchFilter... others) {
		OrCondition orCondition = new OrCondition();
		orCondition.getOrFilters().add(first);
		if (ArrayUtils.isNotEmpty(others)) {
			orCondition.getOrFilters().addAll(Arrays.asList(others));
		}
		return orCondition;
	}
	
	/**
	 * 拼 and 条件
	 * @param first
	 * @param others
	 * @return
	 */
	public static SearchFilter and(SearchFilter first,SearchFilter... others){
		AndCondition andCondition=new AndCondition();
		andCondition.getAndFilters().add(first);
		if(ArrayUtils.isNotEmpty(others)){
			andCondition.getAndFilters().addAll(Arrays.asList(others));
		}
		return andCondition;
	}

}
