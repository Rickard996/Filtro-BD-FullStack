package cl.RicardoC.dto;

//DTO para mi API
public class EstudianteCursoDTO {

	private int idEstudiante;
	private String rut;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String codigoCurso;
	private String nombreCurso; //en descripcion tabla plan_formativo
	private String comunaCurso;
	private int codigoRegion;

	public EstudianteCursoDTO() {
		
	}

	public EstudianteCursoDTO(int idEstudiante, String rut, String nombre, String apellidoPaterno,
			String apellidoMaterno, String codigoCurso, String nombreCurso, String comunaCurso, int codigoRegion) {
		super();
		this.idEstudiante = idEstudiante;
		this.rut = rut;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.codigoCurso = codigoCurso;
		this.nombreCurso = nombreCurso;
		this.comunaCurso = comunaCurso;
		this.codigoRegion = codigoRegion;
	}

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getComunaCurso() {
		return comunaCurso;
	}

	public void setComunaCurso(String comunaCurso) {
		this.comunaCurso = comunaCurso;
	}

	public int getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(int codigoRegion) {
		this.codigoRegion = codigoRegion;
	}
	

	
}
