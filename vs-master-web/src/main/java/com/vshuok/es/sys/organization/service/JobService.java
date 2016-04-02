package com.vshuok.es.sys.organization.service;

import java.util.Iterator;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vshuok.es.common.plugin.service.BaseTreeableService;
import com.vshuok.es.sys.organization.entity.Job;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Service
public class JobService extends BaseTreeableService<Job, Long> {


	/**
	 * 过滤仅获取可显示的数据
	 * @param jobIds
	 * @param organizationJobIds
	 */
	public void filterForCanShow(Set<Long> jobIds,Set<Long[]> organizationJobIds){
		
		Iterator<Long> iter1=jobIds.iterator();
		
		while(iter1.hasNext()){
			Long id=iter1.next();
			Job o=findOne(id);
			if(o==null||Boolean.FALSE.equals(o.getShow())){
				iter1.remove();
			}
		}
		
		Iterator<Long[]> iter2=organizationJobIds.iterator();
		
		while(iter2.hasNext()){
			Long id=iter2.next()[1];
			Job o=findOne(id);
			if(o==null||Boolean.FALSE.equals(o.getShow())){
				iter2.remove();
			}
		}
	}
}
