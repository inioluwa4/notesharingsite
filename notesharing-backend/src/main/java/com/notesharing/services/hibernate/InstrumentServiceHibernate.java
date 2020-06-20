package com.notesharing.services.hibernate;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesharing.data.hibernate.InstrumentDAO;
import com.notesharing.models.Instrument;

@Service
public class InstrumentServiceHibernate implements InstrumentService {
	private Logger log = Logger.getLogger(InstrumentServiceHibernate.class);
	@Autowired
	private InstrumentDAO nd;
	
	@Override
	public Integer createInstrument(Instrument instrument) {
		log.trace("attempting to create instrument");
		nd.createInstrument(instrument);
		return instrument.getId();
	}

	@Override
	public Instrument getInstrument(Instrument instrument) {
		log.trace("attempting to get instrument");
		if(instrument == null) {
			return null;
		}else nd.getInstrument(instrument);
		return instrument;
	}

	@Override
	public Instrument getInstrumentById(Integer id) {
		log.trace("attempting to get instrument");
		if(id == null) {
			return null;
		}else {
			Instrument instrument = nd.getInstrumentById(id);
			return instrument;
		}
	}

	@Override
	public Set<Instrument> getInstruments() {
		log.trace("attempting to get all instruments");
		Set<Instrument> allInstruments = nd.getInstruments();
		return allInstruments;
	}

	@Override
	public void updateInstrument(Instrument instrument) {
		log.trace("attempting to update instrument");
		nd.updateInstrument(instrument);
		
	}

	@Override
	public void deleteInstrument(Instrument instrument) {
		log.trace("attempting to delete instrument");
		nd.deleteInstrument(instrument);
		
	}
	
	

}
