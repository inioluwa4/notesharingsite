package com.notesharing.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "inventory")
@Inheritance(strategy = InheritanceType.JOINED)

public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inventory")
	@SequenceGenerator(name = "inventory", sequenceName = "inventory_seq", allocationSize = 1)
	@Column(name = "item_id")
	private Integer id;

	//constructos
	public Inventory() {
		super();
	}

	public Inventory(Integer id) {
		super();
		this.id = id;
	}

	//get/set
	public Integer getId() {
		return id;
	}

	public void setInventoryId(Integer id) {
		this.id = id;
	}

	//hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "Inventory [id=" + id + "]";
	}
}
