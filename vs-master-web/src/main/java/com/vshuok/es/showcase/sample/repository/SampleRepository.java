package com.vshuok.es.showcase.sample.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.showcase.sample.entity.Sample;


public interface SampleRepository extends BaseRepository<Sample, Long> {

    Sample findByName(String name);

}
