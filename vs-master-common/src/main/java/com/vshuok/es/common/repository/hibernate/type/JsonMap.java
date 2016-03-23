package com.vshuok.es.common.repository.hibernate.type;

import java.io.Serializable;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public class JsonMap implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1556522493355531325L;
	
	private Map<Object, Object> map;

	public JsonMap() {

	}

	public JsonMap(Map<Object, Object> map) {
		this.map = map;
	}
	
	public Map<Object,Object> getMap(){
		if(map==null){
			map=Maps.newHashMap();
		}
		return map;
	}
	
	public void setMap(Map<Object,Object> map){
		this.map=map;
	}
}
