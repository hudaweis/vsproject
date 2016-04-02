package com.vshuok.es.showcase.deleted.service;

import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.showcase.deleted.entity.DeletedSample;
import com.vshuok.es.showcase.deleted.repository.DeletedSampleRepository;
import org.springframework.stereotype.Service;


@Service
public class DeletedSampleService extends BaseService<DeletedSample, Long> {

    private DeletedSampleRepository getSampleRepository() {
        return (DeletedSampleRepository) baseRepository;
    }

    public DeletedSample findByName(String name) {
        return getSampleRepository().findByName(name);
    }

}
