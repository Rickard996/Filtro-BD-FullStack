
package cl.RicardoC.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.RicardoC.dto.EstudianteCursoDTO;
import cl.RicardoC.models.Estudiante;

@Service
public class EstudianteCursoService {

	EstudianteService estudianteService;
	PlanFormativoService planFormativoService;
	RegionService regionService;
	
	public EstudianteCursoService(EstudianteService estudianteService, PlanFormativoService planFormativoService,
			RegionService regionService) {
		super();
		this.estudianteService = estudianteService;
		this.planFormativoService = planFormativoService;
		this.regionService = regionService;
	}



	public List<EstudianteCursoDTO> populateEstudianteCursoDTO(){
		
		List<EstudianteCursoDTO> allEstudianteCurso = new ArrayList<EstudianteCursoDTO>();
		EstudianteCursoDTO estudianteCursoDTO = new EstudianteCursoDTO();
		
		List<Estudiante> allEstudiantes = this.estudianteService.findAllEstudiantes();
		
		for(Estudiante estudiante: allEstudiantes) {
			
			estudianteCursoDTO.setIdEstudiante(estudiante.getIdEstudiante());
			estudianteCursoDTO.setRut(estudiante.getRut());
			estudianteCursoDTO.setNombre(estudiante.getNombreEstudiante());
			estudianteCursoDTO.setApellidoPaterno(estudiante.getApellidoPaterno());
			estudianteCursoDTO.setApellidoMaterno(estudiante.getApellidoMaterno());
			estudianteCursoDTO.setCodigoCurso(estudiante.getCurso().getCodigoCurso());
			estudianteCursoDTO.setNombreCurso(estudiante.getCurso().getPlanFormativo().getDescripcionPlanDFormativo());
			estudianteCursoDTO.setComunaCurso(estudiante.getCurso().getComuna().getNombreComuna());
			estudianteCursoDTO.setCodigoRegion(estudiante.getCurso().getComuna().getRegion().getCodigoRegion());
			
			allEstudianteCurso.add(estudianteCursoDTO);  //añade mi object
			estudianteCursoDTO = new EstudianteCursoDTO();  //reset object
		}
		
		return allEstudianteCurso;
	}
	
	
	public List<EstudianteCursoDTO> estudianteCursoDTOByCodigoCurso(String codigoCurso){
		
		List<EstudianteCursoDTO> allEstudianteCursoDTO = this.populateEstudianteCursoDTO();
		List<EstudianteCursoDTO> estudianteCursoDTOByCodigoCurso = new ArrayList<EstudianteCursoDTO>();
		
		for(EstudianteCursoDTO estudianteCursoDTO: allEstudianteCursoDTO) {
			
			if(estudianteCursoDTO.getCodigoCurso().equals(codigoCurso)) {
				estudianteCursoDTOByCodigoCurso.add(estudianteCursoDTO);
			}
		}
		return estudianteCursoDTOByCodigoCurso;
	}
	
	public List<EstudianteCursoDTO> estudianteCursoDTOByCodigoCursoAndCodigoRegion(String codigoCurso, int codigoRegion){
		
		List<EstudianteCursoDTO> allEstudianteCursoDTO = this.populateEstudianteCursoDTO();
		List<EstudianteCursoDTO> estudianteCursoDTOByCodigoCursoAndCodigoRegion = new ArrayList<EstudianteCursoDTO>();
		
		for(EstudianteCursoDTO estudianteCursoDTO: allEstudianteCursoDTO) {
			
			if(estudianteCursoDTO.getCodigoCurso().equals(codigoCurso) && estudianteCursoDTO.getCodigoRegion()==codigoRegion) {
				estudianteCursoDTOByCodigoCursoAndCodigoRegion.add(estudianteCursoDTO);
			}
		}
		return estudianteCursoDTOByCodigoCursoAndCodigoRegion;
	}
	
	
	public List<EstudianteCursoDTO> estudianteCursoDTOByCodigoRegion(int codigoRegion){
		
		List<EstudianteCursoDTO> allEstudianteCursoDTO = this.populateEstudianteCursoDTO();
		List<EstudianteCursoDTO> estudianteCursoDTOByCodigoRegion = new ArrayList<EstudianteCursoDTO>();
		
		for(EstudianteCursoDTO estudianteCursoDTO: allEstudianteCursoDTO) {
			if(estudianteCursoDTO.getCodigoRegion()==codigoRegion) {
				estudianteCursoDTOByCodigoRegion.add(estudianteCursoDTO);
			}
		}
		return estudianteCursoDTOByCodigoRegion;
	
	}
	
	
	
	
}