package com.vshuok.es.maintain.notification.repository;

import com.vshuok.es.common.repository.BaseRepository;
import com.vshuok.es.maintain.notification.entity.NotificationTemplate;
import org.springframework.data.jpa.repository.Query;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public interface NotificationTemplateRepository extends BaseRepository<NotificationTemplate, Long> {

    @Query("from NotificationTemplate o where name=?1")
    NotificationTemplate findByName(String name);
}
