package com.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="uniforms")
@PrimaryKeyJoinColumn(name="uniforms_inventory_id")



public class Uniform extends Inventory implements IDisplayInv{

	@Column(name = "uniforms_name")
	private String uniformName;
	
	//constructores
	public Uniform() {
		super();
	
	}
	public Uniform(int id) {
		super(id);
	}
	public Uniform(int id, String uniformName) {
		super(id);
		this.uniformName = uniformName;
	}
	//get/set
	@Override
	public String toString() {
		return "Uniform [uniformName=" + uniformName + "]";
	}

	@Override
	public int getProductId() {
		return getId();
	}
	@Override
	public String getProductName() {
		return uniformName;
	}
	/**
	 * @return the uniformName
	 */
	public String getUniformName() {
		return uniformName;
	}
	/**
	 * @param uniformName the uniformName to set
	 */
	public void setUniformName(String uniformName) {
		this.uniformName = uniformName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((uniformName == null) ? 0 : uniformName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Uniform other = (Uniform) obj;
		if (uniformName == null) {
			if (other.uniformName != null)
				return false;
		} else if (!uniformName.equals(other.uniformName))
			return false;
		return true;
	}


}
