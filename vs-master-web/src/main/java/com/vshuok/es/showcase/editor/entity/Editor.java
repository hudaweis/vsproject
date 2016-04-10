package com.vshuok.es.showcase.editor.entity;

import com.vshuok.es.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Entity
@Table(name = "showcase_editor")
public class Editor extends BaseEntity<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8780363972427436037L;

	@Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
