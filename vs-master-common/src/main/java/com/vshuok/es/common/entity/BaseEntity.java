package com.vshuok.es.common.entity;

import java.io.Serializable;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/** 
 * 
 * @author Hu Dawei  
 * @version 1.0
 * @Date：2016年3月22日 下午2:35:59 
 */
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> extends AbstractEntity<ID>{


    /**
	 * 
	 */
	private static final long serialVersionUID = -8346457383929736146L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ID id;

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID id) {
        this.id = id;
    }
}
