package pe.company.service;

import java.util.Collection;
import pe.company.model.Instructor;

public interface InstructorService 
{
	public abstract void insert(Instructor instructor);
	public abstract void update(Instructor instructor);
	public abstract void delete(Integer instructorId);
	public abstract Instructor findById(Integer instructorId);
	public abstract Collection<Instructor> findAll();
}
