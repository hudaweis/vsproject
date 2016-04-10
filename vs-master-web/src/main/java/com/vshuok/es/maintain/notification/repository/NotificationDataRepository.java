package com.vshuok.es.maintain.notification.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.maintain.notification.entity.NotificationData;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface NotificationDataRepository extends BaseRepository<NotificationData, Long> {

    @Modifying
    @Query("update NotificationData o set o.read=true where userId=?1")
    void markReadAll(Long userId);
}
