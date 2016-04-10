package com.vshuok.es.showcase.parentchild.entity;

import com.vshuok.es.common.entity.BaseEntity;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>User: Hu Dawei
 * <p>Version: 1.0
 */
@Entity
@Table(name = "showcase_child")
public class Child extends BaseEntity<Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5532226045084442209L;

	@OneToOne(optional = true)
    @Fetch(FetchMode.SELECT)
    private Parent parent;

    @NotNull(message = "not.null")
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ParentChildType type;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "beginTime")
    private Date beginTime;

    @DateTimeFormat(pattern = "HH:mm:ss")
    @Column(name = "endTime")
    private Date endTime;

    @Column(name = "is_show")
    private Boolean show;

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParentChildType getType() {
        return type;
    }

    public void setType(ParentChildType type) {
        this.type = type;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}
