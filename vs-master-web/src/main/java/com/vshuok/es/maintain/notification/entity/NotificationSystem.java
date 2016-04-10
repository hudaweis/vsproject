package com.vshuok.es.maintain.notification.entity;

/**
 * 触发的子系统
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
public enum NotificationSystem {

    system("系统"), excel("excel");

    private final String info;

    private NotificationSystem(final String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

}
