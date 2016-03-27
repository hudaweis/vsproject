package com.vshuok.es.common.web.validate;

import java.util.List;

import com.google.common.collect.Lists;

/** 
 * <p>验证结果</p>
 * @author Hu Dawei  
 * @version 1.0
 */
public class ValidateResponse {

	/**
	 * 验证成功
	 */
	private static final Integer OK=1;
	
	/**
	 * 验证失败
	 */
	private static final Integer FAIL=0;
	
	private List<Object> results=Lists.newArrayList();
	
	private ValidateResponse(){
		
	}
	
	public static ValidateResponse newInstance(){
		return new ValidateResponse();
	}
	
	/**
	 * 验证失败 (使用前台alertTextOk定义的消息)
	 * @param fieldId
	 */
	public void validateFail(String fieldId){
		validateFail(fieldId,"");
	}
	
	/**
	 * 验证失败
	 * @param fieldId 验证成功的字段名
	 * @param message 验证成功时显示的消息
	 */
	public void validateFail(String fieldId,String message){
		results.add(new Object[]{fieldId,FAIL,message});
	}
	
	/**
	 * 验证成功(使用前台alertTextOk定义的消息)
	 * @param fieldId
	 */
	public void validateSuccess(String fieldId){
		validateSuccess(fieldId,"");
	}
	
	public void validateSuccess(String fieldId,String message){
		results.add(new Object[]{fieldId,OK,message});
	}
	/**
	 * 返回验证结果
	 * @return
	 */
	public Object result(){
		if(results.size()==1){
			return results.get(0);
		}
		return results;
	}
	
}
