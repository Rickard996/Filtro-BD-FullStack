package cl.RicardoC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.RicardoC.models.Region;
import cl.RicardoC.repositories.RegionRepo;

@Service
public class RegionService {

	private RegionRepo regionRepo;

	public RegionService(RegionRepo regionRepo) {
		super();
		this.regionRepo = regionRepo;
	}
	
	public List<Region> findAllRegion(){
		return this.regionRepo.findAll();
	}
	
	public List<Region> findAllRegionByName(String nombreRegion){
		return this.regionRepo.findAllByNombreRegion(nombreRegion);
	}
	
}
