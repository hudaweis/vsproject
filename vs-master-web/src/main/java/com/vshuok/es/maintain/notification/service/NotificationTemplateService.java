package com.vshuok.es.maintain.notification.service;

import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.maintain.notification.entity.NotificationTemplate;
import com.vshuok.es.maintain.notification.repository.NotificationTemplateRepository;
import org.springframework.stereotype.Service;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Service
public class NotificationTemplateService extends BaseService<NotificationTemplate, Long> {

    private NotificationTemplateRepository getNotificationTemplateRepository() {
        return (NotificationTemplateRepository) baseRepository;
    }


    public NotificationTemplate findByName(final String name) {
        return getNotificationTemplateRepository().findByName(name);
    }
}
