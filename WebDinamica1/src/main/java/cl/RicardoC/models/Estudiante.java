package cl.RicardoC.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")    //name of table in BD

public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudiante")
	private int idEstudiante;
	@Column(name = "rut")
	private String rut;
	@Column(name ="nombre")
	private String nombreEstudiante;
	@Column(name = "apellido_pat")
	private String apellidoPaterno;
	@Column(name = "apellido_mat")
	private String apellidoMaterno;
	// private String direccion;   por ahora no me interesa la dirreccion del estudiante, si la del curso
	@Column(name = "codigo_curso", insertable = false, updatable = false)   //importante los false para no crear nuevas columns
	private String codigoCurso;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_curso")
	private Curso curso;    //curso al que pertenece el Estudiante

	//Constructor vacio
	public Estudiante() {
		
	}
	//Getter y setters

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombreEstudiante() {
		return nombreEstudiante;
	}

	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public void setCodigoCurso(String codigoCurso) {
		this.codigoCurso = codigoCurso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
