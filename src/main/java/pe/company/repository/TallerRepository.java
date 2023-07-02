package pe.company.repository;

import org.springframework.data.repository.CrudRepository;
import pe.company.model.Taller;

public interface TallerRepository extends CrudRepository<Taller,Integer> {
	
}
