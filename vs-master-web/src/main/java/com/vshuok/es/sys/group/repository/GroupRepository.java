package com.vshuok.es.sys.group.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.sys.group.entity.Group;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface GroupRepository extends BaseRepository<Group, Long> {

    @Query("select id from Group where defaultGroup=true and show=true")
    List<Long> findDefaultGroupIds();

}
