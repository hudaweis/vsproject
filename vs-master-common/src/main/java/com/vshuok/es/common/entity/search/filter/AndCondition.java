package com.vshuok.es.common.entity.search.filter;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * <p>
 * and 条件
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public class AndCondition implements SearchFilter {

	private List<SearchFilter> andFilters = Lists.newArrayList();

	AndCondition() {

	}

	public AndCondition add(SearchFilter filter) {
		this.andFilters.add(filter);
		return this;
	}

	public List<SearchFilter> getAndFilters() {
		return andFilters;
	}

	public String toString() {
		return "AndCondition{" + andFilters + "}";
	}
}
