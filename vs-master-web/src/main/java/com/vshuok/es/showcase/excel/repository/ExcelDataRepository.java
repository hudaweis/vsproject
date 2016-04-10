package com.vshuok.es.showcase.excel.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.showcase.excel.entity.ExcelData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface ExcelDataRepository extends BaseRepository<ExcelData, Long> {

    public void truncate();

    @Modifying
    @Query(value = "insert into showcase_excel_data (id, content) values(?1,?2)", nativeQuery = true)
    public void save(Long id, String content);

}
