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
@Table(name="instruments")
@PrimaryKeyJoinColumn(name="instruments_inventory_id")


public class Instrument extends Inventory implements IDisplayInv{

	@Column(name = "instrument_name")
	private String instrumentName;

	//constructos
	public Instrument() {
		super();
		
	}
	public Instrument(int id) {
		super(id);
	}
	public Instrument(int id, String instrumentName) {
		super(id);
		this.instrumentName = instrumentName;
	}
	//get/set
	public String getInstrumentName() {
		return instrumentName;
	}
	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}
	@Override
	public String toString() {
		return "Instrument [instrumentName=" + instrumentName + ", getId()=" + getId() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	@Override
	public int getProductId() {
		return getId();
	}
	@Override
	public String getProductName() {
		return instrumentName;
	}




	
}

