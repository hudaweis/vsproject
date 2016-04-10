package com.vshuok.es.sys.user.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.sys.user.entity.UserLastOnline;

/**
 * <p>User: Hu dawei
 * <p>Version: 1.0
 */
public interface UserLastOnlineRepository extends BaseRepository<UserLastOnline, Long> {

    UserLastOnline findByUserId(Long userId);
}
