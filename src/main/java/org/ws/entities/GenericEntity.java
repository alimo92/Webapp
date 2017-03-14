package org.ws.entities;


import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
@MappedSuperclass
public abstract class GenericEntity {
	private Timestamp DateCreated;
	private Timestamp DateUpdated;
	
	public GenericEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GenericEntity(Timestamp dateCreated, Timestamp dateUpdated) {
		super();
		DateCreated = dateCreated;
		DateUpdated = dateUpdated;
	}
	
	public Timestamp getDateUpdated() {
		return DateUpdated;
	}
	public void setDateUpdated(Timestamp dateUpdated) {
		DateUpdated = dateUpdated;
	}
	public Timestamp getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		DateCreated = dateCreated;
	}
	@PrePersist
	void onCreate() {
		this.setDateCreated(new Timestamp((new Date()).getTime()));
	}
	
	@PreUpdate
	void onPersist() {
		this.setDateUpdated(new Timestamp((new Date()).getTime()));
	}
}
