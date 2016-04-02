package com.vshuok.es.sys.user.web.bind.annotation;

import java.lang.annotation.*;

import com.vshuok.es.common.Constants;

/** 
 * <p>绑定当前登录的用户</p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * 当前用户在request中的名字 默认{@link Constants#CURRENT_USER}
     *
     * @return
     */
    String value() default Constants.CURRENT_USER;
}
