package com.vshuok.es.maintain.keyvalue.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.maintain.keyvalue.entity.KeyValue;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface KeyValueRepository extends BaseRepository<KeyValue, Long> {

    KeyValue findByKey(String key);

}
