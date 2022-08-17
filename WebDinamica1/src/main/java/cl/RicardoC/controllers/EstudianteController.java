package cl.RicardoC.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.RicardoC.models.Curso;
import cl.RicardoC.models.Estudiante;
import cl.RicardoC.models.PlanFormativo;
import cl.RicardoC.models.Region;
import cl.RicardoC.services.EstudianteService;
import cl.RicardoC.services.PlanFormativoService;
import cl.RicardoC.services.RegionService;

@Controller
public class EstudianteController {

	EstudianteService estudianteService;
	PlanFormativoService planFormativoService;
	RegionService regionService;
	
	public EstudianteController(EstudianteService estudianteService, PlanFormativoService planFormativoService,
			RegionService regionService) {
		super();
		this.estudianteService = estudianteService;
		this.planFormativoService = planFormativoService;
		this.regionService = regionService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listadoyBusqueda(Model model, HttpSession session) {
		
		if(session.getAttribute("estudiantesFiltrados")!=null) {
			model.addAttribute("estudiantesFiltrados", session.getAttribute("estudiantesFiltrados"));
		}
		
		List<Region> allRegiones = this.regionService.findAllRegion();
		List<PlanFormativo> allPlanesFormativos = this.planFormativoService.findAllPlanFormativo();
		
		model.addAttribute("allRegiones", allRegiones);
		model.addAttribute("allPlanesFormativos", allPlanesFormativos);
		return "listado.jsp";
	}
	
	//en method POST hago el filtrado y vuelve a redireccionar /
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String filter(@RequestParam(value = "region") String region,
			@RequestParam(value = "curso") String curso, Model model, HttpSession session) {
		
		List<Estudiante> allEstudiantes = this.estudianteService.findAllEstudiantes();
		
		List<Estudiante> estudiantesFiltrados = new ArrayList<Estudiante>();
		List<PlanFormativo> planFormativoFiltrado = new ArrayList<PlanFormativo>();
		
		//parseint for region
		int regionInt = Integer.parseInt(region);  
//		System.out.println(regionInt+" "+curso);
		
		if(!region.equals("0") && curso.equals("0")) {   //solo si el curso es distinto de cero, only filter by region
			
			for(Estudiante estudiante: allEstudiantes) {
				if(estudiante.getCurso().getComuna().getRegion().getCodigoRegion()==regionInt) {
					estudiantesFiltrados.add(estudiante);  //populate my list with the selected students
				}
			}
		}
		
		if(region.equals("0") && !curso.equals("0")) {  //si nombre curso solamente es distinto de cero
			for(Estudiante estudiante: allEstudiantes) {
				if(estudiante.getCurso().getPlanFormativo().getCodigoPlanFormativo().equals(curso)) {
					estudiantesFiltrados.add(estudiante);
				}
			}
		}
		
		if(!region.equals("0") && !curso.equals("0")) {  //si ambos no son 0, es decir deben ser filtrados
			for(Estudiante estudiante: allEstudiantes) {
				if(estudiante.getCurso().getComuna().getRegion().getCodigoRegion()==regionInt &&
						estudiante.getCurso().getPlanFormativo().getCodigoPlanFormativo().equals(curso)) {
					
					estudiantesFiltrados.add(estudiante);
				}
			}
		}
		
		session.setAttribute("estudiantesFiltrados", estudiantesFiltrados);

		return "redirect:/";
	}
	
}
