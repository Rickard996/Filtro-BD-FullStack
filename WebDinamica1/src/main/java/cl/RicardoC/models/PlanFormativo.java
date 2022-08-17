package cl.RicardoC.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "plan_formativo")

public class PlanFormativo {

	@Id
	@Column(name = "codigo_plan_formativo")
	private String codigoPlanFormativo;
	
	@Column(name = "descripcion")
	private String descripcionPlanFormativo;
	@Column(name = "duracion_horas")
	private int duracionPlanFormativo;
	
	@OneToMany(mappedBy = "planFormativo", fetch = FetchType.EAGER)
	private List<Curso> cursosEnPlanFormativo;

	//Constructor vacio
	public PlanFormativo() {
		
	}

	//Getter y setter
	public String getCodigoPlanFormativo() {
		return codigoPlanFormativo;
	}

	public void setCodigoPlanFormativo(String codigoPlanFormativo) {
		this.codigoPlanFormativo = codigoPlanFormativo;
	}

	public String getDescripcionPlanDFormativo() {
		return descripcionPlanFormativo;
	}

	public void setDescripcionPlanDFormativo(String descripcionPlanDFormativo) {
		this.descripcionPlanFormativo = descripcionPlanDFormativo;
	}

	public int getDuracionPlanFormativo() {
		return duracionPlanFormativo;
	}

	public void setDuracionPlanFormativo(int duracionPlanFormativo) {
		this.duracionPlanFormativo = duracionPlanFormativo;
	}

	public List<Curso> getCursosEnPlanFormativo() {
		return cursosEnPlanFormativo;
	}

	public void setCursosEnPlanFormativo(List<Curso> cursosEnPlanFormativo) {
		this.cursosEnPlanFormativo = cursosEnPlanFormativo;
	}
	
}
