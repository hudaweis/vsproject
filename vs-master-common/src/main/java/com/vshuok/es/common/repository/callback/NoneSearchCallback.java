package com.vshuok.es.common.repository.callback;

import javax.persistence.Query;

import com.vshuok.es.common.entity.search.Searchable;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public final class NoneSearchCallback implements SearchCallback {

    @Override
    public void prepareQL(StringBuilder ql, Searchable search) {
    }

    @Override
    public void prepareOrder(StringBuilder ql, Searchable search) {
    }

    @Override
    public void setValues(Query query, Searchable search) {
    }

    @Override
    public void setPageable(Query query, Searchable search) {
    }
}
