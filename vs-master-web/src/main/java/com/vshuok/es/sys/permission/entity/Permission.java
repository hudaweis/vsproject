package com.vshuok.es.sys.permission.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.vshuok.es.common.entity.BaseEntity;
import com.vshuok.es.common.repository.support.annotation.EnableQueryCache;

import org.hibernate.annotations.CacheConcurrencyStrategy;
/** 
 * <p>权限表</p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Entity
@Table(name = "sys_permission")
@EnableQueryCache
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Permission extends BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3407386996089042452L;

	 /**
     * 前端显示名称
     */
    private String name;
    /**
     * 系统中验证时使用的权限标识
     */
    private String permission;

    /**
     * 详细描述
     */
    private String description;

    /**
     * 是否显示 也表示是否可用 为了统一 都使用这个
     */
    @Column(name = "is_show")
    private Boolean show = Boolean.FALSE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }
}