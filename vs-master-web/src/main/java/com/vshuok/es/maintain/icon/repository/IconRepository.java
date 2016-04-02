package com.vshuok.es.maintain.icon.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.maintain.icon.entity.Icon;


public interface IconRepository extends BaseRepository<Icon, Long> {
    Icon findByIdentity(String identity);
}
