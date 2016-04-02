package com.vshuok.es.sys.auth.repository;

import java.util.Set;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.sys.auth.entity.Auth;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public interface AuthRepository extends BaseRepository<Auth, Long> {

    Auth findByUserId(Long userId);

    Auth findByGroupId(Long groupId);

    Auth findByOrganizationIdAndJobId(Long organizationId, Long jobId);

    ///////////委托给AuthRepositoryImpl实现
	public Set<Long> findRoleIds(Long userId, Set<Long> groupIds,
			Set<Long> organizationIds, Set<Long> jobIds, Set<Long[]> organizationJobIds);
}
