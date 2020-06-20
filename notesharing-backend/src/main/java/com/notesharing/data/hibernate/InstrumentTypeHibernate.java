package com.notesharing.data.hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.notesharing.models.InstrumentType;
import com.notesharing.utils.HibernateUtil;

@Repository
public class InstrumentTypeHibernate implements InstrumentTypeDAO {
	
	private HibernateUtil hu = HibernateUtil.getInstance();

	@Override
	public InstrumentType getInstrumentType(InstrumentType instrumentType) {
		Session s = hu.getSession();
		instrumentType = s.get(InstrumentType.class, instrumentType.getId());
		s.close();
		return instrumentType;
		
	}

	
}
