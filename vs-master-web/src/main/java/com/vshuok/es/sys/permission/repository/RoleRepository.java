package com.vshuok.es.sys.permission.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.sys.permission.entity.Role;
import com.vshuok.es.sys.permission.entity.RoleResourcePermission;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface RoleRepository extends BaseRepository<Role, Long> {

    @Query("from RoleResourcePermission where role=?1 and resourceId=?2")
    RoleResourcePermission findRoleResourcePermission(Role role, Long resourceId);
}
