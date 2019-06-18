package com.blog.entity;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;



@MappedSuperclass
public abstract class Auditable extends BaseEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The created at. */
	@Column(name = "created_at")
	@Basic(fetch = FetchType.LAZY)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	/** The created by. */
	@Size(max = 20)
	@Column(name = "created_by", length = 20)
	@Basic(fetch = FetchType.LAZY)
	private String createdBy;

	/** The updated at. */
	@Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
	@Basic(fetch = FetchType.LAZY)
	private Date updatedAt;

	/** The updated by. */
	@Size(max = 20)
	@Column(name = "updated_by")
	@Basic(fetch = FetchType.LAZY)
	private String updatedBy;

	/**
	 * Gets the created at.
	 * 
	 * @return the created at
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * Gets the created by.
	 * 
	 * @return the created by
	 */
	public String getCreatedBy() {
		return createdBy;
	}


	/**
	 * Gets the updated at.
	 * 
	 * @return the updated at
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * Gets the updated by.
	 * 
	 * @return the updated by
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Sets the change date.
	 */
	@PreUpdate
	public void setChangeDate() {
		this.updatedAt = new Date();
	}

	/**
	 * Sets the created at.
	 * 
	 * @param createdAt the new created at
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * Sets the created by.
	 * 
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Sets the creation date.
	 */
	@PrePersist
	public void setCreationDate() {
		this.createdAt = new Date();
	}

	/**
	 * Sets the updated at.
	 * 
	 * @param updatedAt the new updated at
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * Sets the updated by.
	 * 
	 * @param updatedBy the new updated by
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
