package cl.RicardoC.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.RicardoC.models.PlanFormativo;

@Repository
public interface PlanFormativoRepo extends CrudRepository<PlanFormativo, String>{

	public List<PlanFormativo> findAllByDescripcionPlanFormativo(String descripcionPlanFormativo);
	public List<PlanFormativo> findAll();
	
	
}
