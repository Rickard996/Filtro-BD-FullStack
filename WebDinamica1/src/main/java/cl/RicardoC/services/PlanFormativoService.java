package cl.RicardoC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.RicardoC.models.PlanFormativo;
import cl.RicardoC.repositories.PlanFormativoRepo;

@Service
public class PlanFormativoService {

	private PlanFormativoRepo planFormativoRepo;

	public PlanFormativoService(PlanFormativoRepo planDFormativoRepo) {
		super();
		this.planFormativoRepo = planDFormativoRepo;
	}
	
	//Busco por curso (descripcion en Plan formativo)
	public List<PlanFormativo> findAllPlanFormativoByDescription(String descripcionPlanFormativo){
		return this.planFormativoRepo.findAllByDescripcionPlanFormativo(descripcionPlanFormativo);
	}
	
	public List<PlanFormativo> findAllPlanFormativo(){
		return this.planFormativoRepo.findAll();
	}
	
	
	
}
