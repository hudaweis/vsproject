package com.vshuok.es.maintain.icon.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.maintain.icon.entity.Icon;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface IconRepository extends BaseRepository<Icon, Long> {
    Icon findByIdentity(String identity);
}
