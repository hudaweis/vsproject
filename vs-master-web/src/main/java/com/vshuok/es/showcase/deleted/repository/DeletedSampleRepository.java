package com.vshuok.es.showcase.deleted.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.showcase.deleted.entity.DeletedSample;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface DeletedSampleRepository extends BaseRepository<DeletedSample, Long> {

    DeletedSample findByName(String name);

}
