package com.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "statuses")

public class Status {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "statuses")
	@SequenceGenerator(name = "statuses", sequenceName = "statuses_seq", allocationSize = 1)
	@Column(name = "status_id")
	private Integer statusId;
	@Column(name = "status_type")
	private String statusType;
	
	
	public Status() {
		super();
		
	}
	public Status(Integer statusId) {
		super();
		this.statusId = statusId;
	}
	public Status(Integer statusId, String statusType) {
		super();
		this.statusId = statusId;
		this.statusType = statusType;
	}
	public Integer getStatusId() {
		return statusId;
	}
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	public String getStatusType() {
		return statusType;
	}
	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}
	
	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusType=" + statusType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((statusId == null) ? 0 : statusId.hashCode());
		result = prime * result + ((statusType == null) ? 0 : statusType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		if (statusType == null) {
			if (other.statusType != null)
				return false;
		} else if (!statusType.equals(other.statusType))
			return false;
		return true;
	}

}
