package cl.RicardoC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.RicardoC.dto.EstudianteCursoDTO;
import cl.RicardoC.services.EstudianteCursoService;
import cl.RicardoC.services.EstudianteService;
import cl.RicardoC.services.PlanFormativoService;
import cl.RicardoC.services.RegionService;

@RestController
public class ApiController {

	@Autowired
	EstudianteService estudianteService;
	@Autowired
	PlanFormativoService planFormativoService;
	@Autowired
	RegionService regionService;
	@Autowired
	EstudianteCursoService estudianteCursoService;
	
	//Cursos by codigoCurso and codigoRegion
	@GetMapping(value = "/api/v1/cursos/{codigoCurso}/{codigoRegion}")
	public List<EstudianteCursoDTO> findByRegionAndByNombreCurso(@PathVariable(value = "codigoRegion") String codigoRegion,
			@PathVariable(value = "codigoCurso") String codigoCurso) {
		
		return this.estudianteCursoService.estudianteCursoDTOByCodigoCursoAndCodigoRegion(codigoCurso, Integer.parseInt(codigoRegion));
	}
	
	//Cursos by codigoCurso
	@GetMapping(value = "/api/v1/cursos/{codigoCurso}")
	public List<EstudianteCursoDTO> findByRegion(@PathVariable(value = "codigoCurso") String codigoCurso){
		return this.estudianteCursoService.estudianteCursoDTOByCodigoCurso(codigoCurso);
	}
	
	//All the cursos
	@GetMapping(value = "/api/v1/cursos")
	public List<EstudianteCursoDTO> findAllEstudiantes(){
		return this.estudianteCursoService.populateEstudianteCursoDTO();
	}
	
	//cursos solo por region
	
	@GetMapping(value = "api/v1/cursos/region/{codigoRegion}")
	public List<EstudianteCursoDTO> findCursosByRegion(@PathVariable(value = "codigoRegion") String codigoRegion){
		return this.estudianteCursoService.estudianteCursoDTOByCodigoRegion(Integer.parseInt(codigoRegion));
	}
	
	
	
	
	
	
	
}
