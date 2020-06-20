package com.notesharing.services.hibernate;

import java.util.Set;

import com.notesharing.models.Instrument;

public interface InstrumentService {
	public Integer createInstrument(Instrument instrument);
	public Instrument getInstrument(Instrument instrument);
	public Instrument getInstrumentById(Integer id);
	public Set<Instrument> getInstruments();
	public void updateInstrument(Instrument instrument);
	public void deleteInstrument(Instrument instrument);
	
}
