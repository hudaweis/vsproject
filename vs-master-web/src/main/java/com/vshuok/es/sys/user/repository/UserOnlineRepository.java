package com.vshuok.es.sys.user.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.sys.user.entity.UserOnline;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public interface UserOnlineRepository extends
		BaseRepository<UserOnline, String> {

    @Query("from UserOnline o where o.lastAccessTime < ?1 order by o.lastAccessTime asc")
    Page<UserOnline> findExpiredUserOnlineList(Date expiredDate, Pageable pageable);

    @Modifying
    @Query("delete from UserOnline o where o.id in (?1)")
    void batchDelete(List<String> needExpiredIdList);
}
