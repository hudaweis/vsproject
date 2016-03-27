package com.vshuok.es.common.web.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vshuok.es.common.web.filter.BaseFilter;

/** 
 * <p>设置通用数据的Filter<br/>
 * 使用Filter时 文件上传时 getParameter时为null 所以改成Interceptor
 * </p>
 * @author Hu Dawei  
 * @version 1.0
 */
public class SetCommonDataFilter extends BaseFilter {

    private SetCommonDataInterceptor setCommonDataInterceptor = new SetCommonDataInterceptor();

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            //使用Filter时 文件上传时 getParameter时为null 所以改成Interceptor
            setCommonDataInterceptor.preHandle(request, response, null);
        } catch (Exception e) {
            throw new ServletException(e);
        }
        chain.doFilter(request, response);
    }
}
