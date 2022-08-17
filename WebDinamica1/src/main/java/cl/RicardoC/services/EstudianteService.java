package cl.RicardoC.services;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.RicardoC.models.Estudiante;
import cl.RicardoC.repositories.EstudianteRepo;

@Service
public class EstudianteService {

	private EstudianteRepo estudianteRepo;

	public EstudianteService(EstudianteRepo estudianteRepo) {
		super();
		this.estudianteRepo = estudianteRepo;
	}
	
	public List<Estudiante> findAllEstudiantes(){
		return (List<Estudiante>) this.estudianteRepo.findAll();
	}
	
}
