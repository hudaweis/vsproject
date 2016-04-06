package com.vshuok.es.maintain.notification.entity;

import com.vshuok.es.common.entity.BaseEntity;
import com.vshuok.es.common.plugin.entity.LogicDeleteable;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 消息通知模板
 */
@Entity
@Table(name = "maintain_notification_template")
public class NotificationTemplate extends BaseEntity<Long> implements LogicDeleteable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8035637161285624544L;

	/**
     * 模板名称 必须唯一 发送时使用
     */
    @NotNull(message = "{not.null}")
    @Length(min=1, max=100, message = "{length.not.valid}")
    private String name;

    /**
     * 所属系统
     */
    @NotNull(message = "{not.null}")
    @Enumerated(EnumType.STRING)
    private NotificationSystem system;


    /**
     * 模板标题
     */
    @Length(min=1, max=200, message = "{length.not.valid}")
    private String title;


    /**
     * 模板内容
     */
    private String template;

    /**
     * 是否已逻辑删除
     */
    private Boolean deleted = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public NotificationSystem getSystem() {
        return system;
    }

    public void setSystem(final NotificationSystem system) {
        this.system = system;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(final String template) {
        this.template = template;
    }

    public Boolean getDelete() {
        return deleted;
    }

    public void setDelete(final Boolean deleted) {
        this.deleted = deleted;
    }

    public void markDeleted() {
        setDelete(Boolean.TRUE);
    }

}
