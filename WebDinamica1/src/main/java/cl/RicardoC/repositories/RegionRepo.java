package cl.RicardoC.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.RicardoC.models.Region;

@Repository
public interface RegionRepo extends CrudRepository<Region, Integer>{

	public List<Region> findAll();
	public List<Region> findAllByNombreRegion(String nombreRegion);
	
}
