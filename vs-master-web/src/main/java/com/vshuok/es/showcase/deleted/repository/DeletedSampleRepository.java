package com.vshuok.es.showcase.deleted.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.showcase.deleted.entity.DeletedSample;


public interface DeletedSampleRepository extends BaseRepository<DeletedSample, Long> {

    DeletedSample findByName(String name);

}
