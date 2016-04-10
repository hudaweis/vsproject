package com.vshuok.es.showcase.upload.entity;

import com.vshuok.es.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Entity
@Table(name = "showcase_upload")
public class Upload extends BaseEntity<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8122522203893458484L;

	@Column(name = "name")
    private String name;

    @Column(name = "src")
    private String src;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
