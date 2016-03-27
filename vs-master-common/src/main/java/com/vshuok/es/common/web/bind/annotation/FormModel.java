package com.vshuok.es.common.web.bind.annotation;

import java.lang.annotation.*;
/** 
 * <p>绑定请求参数到模型，并暴露到模型中供页面使用</p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FormModel {

	String value();
}
