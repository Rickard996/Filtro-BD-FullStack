package cl.RicardoC.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@Column(name = "codigo_curso")
	private String codigoCurso;  //la PK es un String
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	@Column(name = "fecha_termno")    //en bd esta como fecha_termno
	private Date fechaTermino;
	@Column(name = "codigo_comuna")
	private int codigoComuna;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_plan_formativo", updatable = false, insertable = false)
	private PlanFormativo planFormativo;
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
	private List<Estudiante> estudiantes;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_comuna", updatable = false, insertable = false)
	private Comuna comuna;
	//Constructor vacio
	public Curso() {
		
	}
	public String getCodigoCurso() {
		return codigoCurso;
	}
	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaTermino() {
		return fechaTermino;
	}
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	public int getCodigoComuna() {
		return codigoComuna;
	}
	public void setCodigoComuna(int codigoComuna) {
		this.codigoComuna = codigoComuna;
	}
	public PlanFormativo getPlanFormativo() {
		return planFormativo;
	}
	public void setPlanFormativo(PlanFormativo planFormativo) {
		this.planFormativo = planFormativo;
	}
	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}
	public Comuna getComuna() {
		return comuna;
	}
	public void setComuna(Comuna comuna) {
		this.comuna = comuna;
	}
	
}
