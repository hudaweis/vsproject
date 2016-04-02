package com.vshuok.es.sys.group.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.sys.group.entity.Group;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public interface GroupRepository extends BaseRepository<Group, Long> {

    @Query("select id from Group where defaultGroup=true and show=true")
    List<Long> findDefaultGroupIds();
}
