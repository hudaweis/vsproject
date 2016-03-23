package com.vshuok.es.common.repository.support.annotation;

import java.lang.annotation.*;

import javax.persistence.criteria.JoinType;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryJoin {

    /**
     * 连接的名字
     * @return
     */
    String property();

    JoinType joinType();
}
