package com.vshuok.es.maintain.icon.service;

import com.vshuok.es.common.service.BaseService;
import com.vshuok.es.maintain.icon.entity.Icon;
import com.vshuok.es.maintain.icon.repository.IconRepository;
import org.springframework.stereotype.Service;


@Service
public class IconService extends BaseService<Icon, Long> {

    private IconRepository getIconRepository() {
        return (IconRepository) baseRepository;
    }

    public Icon findByIdentity(String identity) {
        return getIconRepository().findByIdentity(identity);
    }
}
