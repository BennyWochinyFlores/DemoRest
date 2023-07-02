package pe.company.service;

import java.util.Collection;

import pe.company.model.Conyuge;

public interface ConyugeService {
	public abstract void insert(Conyuge conyuge);
	public abstract void update(Conyuge conyuge);
	public abstract void delete(Integer conyugeid);
	public abstract Conyuge findById(Integer conyugeid);
	public abstract Collection<Conyuge> findAll();

}
