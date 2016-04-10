package com.vshuok.es.showcase.sample.service;

import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.showcase.sample.entity.Sample;
import com.vshuok.es.showcase.sample.repository.SampleRepository;
import org.springframework.stereotype.Service;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Service
public class SampleService extends BaseService<Sample, Long> {

    private SampleRepository getSampleRepository() {
        return (SampleRepository) baseRepository;
    }


    public Sample findByName(String name) {
        return getSampleRepository().findByName(name);
    }

}
