package pe.company.service;

import java.util.Collection;
import pe.company.model.Tecnologia;

public interface TecnologiaService {
	public abstract void insert(Tecnologia tecnologia);
	public abstract void update(Tecnologia tecnologia);
	public abstract void delete(Integer tecnologiaid);
	public abstract Tecnologia findById(Integer tecnologiaid);
	public abstract Collection<Tecnologia> findAll();


}