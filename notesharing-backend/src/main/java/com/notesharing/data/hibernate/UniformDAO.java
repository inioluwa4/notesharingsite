package com.notesharing.data.hibernate;

import java.util.Set;

import com.notesharing.models.Uniform;

public interface UniformDAO {

	public Integer createUniform(Uniform uniform);
	public Uniform getUniform(Uniform uniform);
	public Uniform getUniformById(Integer id);
	public Set<Uniform> getUniforms();
	public Set<Uniform> getUnapprovedUniforms();
	public void updateUniform(Uniform uniform);
	public void deleteUniform(Uniform uniform);
}
