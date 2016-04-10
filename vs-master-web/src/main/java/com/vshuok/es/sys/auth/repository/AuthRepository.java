package com.vshuok.es.sys.auth.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.sys.auth.entity.Auth;

import java.util.Set;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface AuthRepository extends BaseRepository<Auth, Long> {

    Auth findByUserId(Long userId);

    Auth findByGroupId(Long groupId);

    Auth findByOrganizationIdAndJobId(Long organizationId, Long jobId);

    ///////////委托给AuthRepositoryImpl实现
    public Set<Long> findRoleIds(Long userId, Set<Long> groupIds, Set<Long> organizationIds, Set<Long> jobIds, Set<Long[]> organizationJobIds);

}
