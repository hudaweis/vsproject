package com.vshuok.es.common.entity.search.filter;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public class OrCondition implements SearchFilter {

	private List<SearchFilter> orFilters = Lists.newArrayList();

	OrCondition() {
	}

	public OrCondition add(SearchFilter filter) {
		this.orFilters.add(filter);
		return this;
	}

	public List<SearchFilter> getOrFilters() {
		return orFilters;
	}

	public String toString() {
		return "OrCondition{" + orFilters + "}";
	}
}
