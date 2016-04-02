package com.vshuok.es.sys.user.service;

import org.springframework.stereotype.Service;

import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.sys.user.entity.UserLastOnline;
import com.vshuok.es.sys.user.repository.UserLastOnlineRepository;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Service
public class UserLastOnlineService extends BaseService<UserLastOnline, Long> {

	private UserLastOnlineRepository getUserLastOnlineRepository() {
	        return (UserLastOnlineRepository) baseRepository;
	    }


	    public UserLastOnline findByUserId(Long userId) {
	        return getUserLastOnlineRepository().findByUserId(userId);
	    }

	    public void lastOnline(UserLastOnline lastOnline) {
	        UserLastOnline dbLastOnline = findByUserId(lastOnline.getUserId());

	        if (dbLastOnline == null) {
	            dbLastOnline = lastOnline;
	        } else {
	            UserLastOnline.merge(lastOnline, dbLastOnline);
	        }
	        dbLastOnline.incLoginCount();
	        dbLastOnline.incTotalOnlineTime();
	        //相对于save or update
	        save(dbLastOnline);
	    }
}
