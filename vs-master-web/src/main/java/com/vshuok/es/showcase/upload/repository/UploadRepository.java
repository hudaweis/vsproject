package com.vshuok.es.showcase.upload.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.showcase.upload.entity.Upload;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface UploadRepository extends BaseRepository<Upload, Long> {

    Upload findByName(String name);

}
