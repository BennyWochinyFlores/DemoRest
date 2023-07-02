package pe.company.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.company.model.Taller;
import pe.company.repository.TallerRepository;

@Service
public class TallerServiceImpl implements TallerService {
	
		@Autowired
		private TallerRepository repository;
		@Override
		@Transactional
		public void insert(Taller taller) {
			repository.save(taller);
		}

		@Override
		@Transactional
		public void update(Taller taller) {
			repository.save(taller);		
		}

		@Override
		@Transactional
		public void delete(Integer tallerId) {
			repository.deleteById(tallerId);		
		}

		@Override
		@Transactional(readOnly=true)
		public Taller findById(Integer tallerId) {
			return repository.findById(tallerId).orElse(null);
		}

		@Override
		@Transactional(readOnly=true)
		public Collection<Taller> findAll() {
			return (Collection<Taller>)repository.findAll();
		}	
	}
