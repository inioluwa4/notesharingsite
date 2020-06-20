package com.notesharing.data.hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.notesharing.models.UniformType;
import com.notesharing.utils.HibernateUtil;

@Repository
public class UniformTypeHibernate implements UniformTypeDAO{

	private HibernateUtil hu = HibernateUtil.getInstance();
	
	@Override
	public UniformType getUniformType(UniformType uniformType) {
		Session s = hu.getSession();
		uniformType = s.get(UniformType .class, uniformType.getId());
		s.close();
		return uniformType;
		
	}

}
