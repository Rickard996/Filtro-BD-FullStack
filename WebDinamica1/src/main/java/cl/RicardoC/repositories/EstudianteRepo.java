package cl.RicardoC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.RicardoC.models.Estudiante;

@Repository
public interface EstudianteRepo extends CrudRepository<Estudiante, Integer>{
	
}
