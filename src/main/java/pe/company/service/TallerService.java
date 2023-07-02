package pe.company.service;

import java.util.Collection;

import pe.company.model.Taller;

public interface TallerService {
	public abstract void insert(Taller taller);
	public abstract void update(Taller taller);
	public abstract void delete(Integer tallerid);
	public abstract Taller findById(Integer tallerid);
	public abstract Collection<Taller> findAll();

}
