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
@Table(name="uniform_type")


public class UniformType {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uniform_type")
	@SequenceGenerator(name = "uniform_type", sequenceName = "uniform_type_seq", allocationSize = 1)
	@Column(name = "uniform_type_id")
	private Integer id; 
	@Column(name = "uniform_type_name")
	private String name;
	public UniformType() {
		super();
	
	}
	public UniformType(Integer id) {
		super();
		this.id = id;
	
	}
	public UniformType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		UniformType other = (UniformType) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "InstrumentType [id=" + id + ", name=" + name + "]";
	}
	
}
