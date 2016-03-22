package com.vshuok.es.common.entity;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.data.domain.Persistable;

/**
 * 抽象实体基类，如果主键是数据库端自动生成 请使用{@link BaseEntity}，如果是Oracle 请使用
 * {@link BaseOracleEntity}
 * 
 * @author David
 *
 */
public abstract class AbstractEntity<ID extends Serializable> implements
		Persistable<ID> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract ID getId();

	public abstract void setId(final ID id);

	public boolean isNew() {
		return null == getId();
	}

	public boolean equals(Object obj) {
		if (null == obj) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		AbstractEntity<?> that = (AbstractEntity<?>) obj;
		return null == this.getId() ? false : this.getId().equals(that.getId());
	}

	public int hashCode() {
		int hashCode = 0;
		hashCode += (getId() != null ? getId().hashCode() : 0);
		return hashCode;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
