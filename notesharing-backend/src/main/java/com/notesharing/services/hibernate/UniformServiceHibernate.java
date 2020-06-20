package com.notesharing.services.hibernate;

import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notesharing.data.hibernate.UniformDAO;
import com.notesharing.models.Uniform;
@Service
public class UniformServiceHibernate implements UniformService{
	private Logger log = Logger.getLogger(RequestServiceHibernate.class);
	@Autowired
	private UniformDAO ud;
	
	@Override
	public Integer createUniform(Uniform uniform) {
		log.trace("attempting to create uniform");
		ud.createUniform(uniform);
		return uniform.getId();
	}

	@Override
	public Uniform getUniform(Uniform uniform) {
		log.trace("attempting to get uniform");
		if(uniform == null) {
			return null;
		}else ud.getUniform(uniform);
		return uniform;
	}

	@Override
	public Uniform getUniformById(Integer id) {
		log.trace("attempting to get uniform");
		if(id == null) {
			return null;
		}else {
			Uniform uniform = ud.getUniformById(id);
			return uniform;
		}
	}

	@Override
	public Set<Uniform> getUniforms() {
		log.trace("attempting to get all uniforms");
		Set<Uniform> allUniforms = ud.getUniforms();
		return allUniforms;
	}

	@Override
	public void updateUniform(Uniform uniform) {
		log.trace("attempting to update uniform");
		ud.updateUniform(uniform);
		
	}

	@Override
	public void deleteUniform(Uniform uniform) {
		log.trace("attempting to delete uniform");
		ud.deleteUniform(uniform);
		
	}
	
	

}
