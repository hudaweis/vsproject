package com.vshuok.es.common.plugin.entity;
/** 
 * <p>实体实现该接口表示想要调整数据的顺序<br/>
 * 优先级值越大则展示时顺序越靠前 比如 2 排在 1 前边
 * </p>
 * @author Hu Dawei  
 * @version 1.0
 */
public interface Movable {

	public Integer getWeight();
	
	public void setWeigth(Integer weight);
}
