package com.vshuok.es.showcase.status.show.entity;

import com.vshuok.es.common.entity.BaseEntity;
import com.vshuok.es.common.plugin.entity.Stateable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;


@Entity
@Table(name = "showcase_status_show")
public class Show extends BaseEntity<Long> implements Stateable<Stateable.ShowStatus> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1419129045233166203L;

	/**
     * 标题
     */
    private String name;

    @Enumerated(EnumType.STRING)
    private ShowStatus status;

    public ShowStatus getStatus() {
        return status;
    }

    public void setStatus(ShowStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
