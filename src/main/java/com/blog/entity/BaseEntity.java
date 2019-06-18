/*
 *
 */
package com.blog.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.stereotype.Component;

@Component
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	/** The Constant ACTIVE_COLUMN. */
	public static final String ACTIVE_COLUMN = "active";

	/** The Constant DELETED_COLUMN. */
	public static final String DELETED_COLUMN = "deleted";

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The active. */
	@Column(nullable = false, columnDefinition = "BOOLEAN default '1'")
	protected Boolean active = true;

	/** The deleted. */
	@Column(nullable = false, columnDefinition = "BOOLEAN default '0'")
	protected boolean deleted = false;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id", nullable = false, updatable = false, columnDefinition = "BIGINT UNSIGNED")
	protected Long id;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null) return false;
		if (getClass() != object.getClass()) return false;

		BaseEntity other = (BaseEntity) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}


	/**
	 * Gets the active.
	 * 
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * Gets the deleted.
	 * 
	 * @return the deleted
	 */
	public boolean getDeleted() {
		return deleted;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (this.getId() != null ? this.getId().hashCode() : 0);

		return hash;
	}

	/**
	 * Sets the active.
	 * 
	 * @param active the new active
 */
	public void setActive(Boolean active) {
		this.active = active;
	} 

	/**
	 * Sets the deleted.
	 * 
	 * @param deleted the new deleted
	 */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getClass().getName() + " [ID=" + id + "]";
	}

}
