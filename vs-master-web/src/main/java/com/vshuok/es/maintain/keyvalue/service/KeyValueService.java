package com.vshuok.es.maintain.keyvalue.service;

import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.maintain.keyvalue.entity.KeyValue;
import com.vshuok.es.maintain.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Service;


@Service
public class KeyValueService extends BaseService<KeyValue, Long> {

    private KeyValueRepository getKeyValueRepository() {
        return (KeyValueRepository) baseRepository;
    }


    public KeyValue findByKey(String key) {
        return getKeyValueRepository().findByKey(key);
    }

}
