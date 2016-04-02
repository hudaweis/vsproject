package com.vshuok.es.showcase.upload.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.showcase.upload.entity.Upload;


public interface UploadRepository extends BaseRepository<Upload, Long> {

    Upload findByName(String name);

}
