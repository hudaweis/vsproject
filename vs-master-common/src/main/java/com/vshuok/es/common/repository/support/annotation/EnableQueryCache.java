package com.vshuok.es.common.repository.support.annotation;

import java.lang.annotation.*;

/** 
 * <p>开启查询缓存</p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnableQueryCache {

	boolean value() default true;
}
