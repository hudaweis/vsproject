package com.vshuok.es.common.web.bind.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * 默认的分页数据，先从参数找，参数找不到从方法上找
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
@Target({ ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PageableDefaults {

	int value() default 10;

	int pageNumber() default 0;

	String[] sort() default {};
}
