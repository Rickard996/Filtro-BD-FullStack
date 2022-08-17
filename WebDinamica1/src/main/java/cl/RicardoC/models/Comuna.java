package cl.RicardoC.models;

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
@Table(name = "comuna")
public class Comuna {

	@Id
	@Column(name = "codigo_comuna")
	private int codigoComuna;
	@Column(name = "nombre")
	private String nombreComuna;
	@Column(name = "codigo_region")
	private int codigoRegion;
	
	@OneToMany(mappedBy = "comuna", fetch = FetchType.EAGER)
	private List<Curso> cursosEnComuna;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_region", updatable = false, insertable = false)
	private Region region;

	//Constructor vacio
	public Comuna() {
		super();
	}

	//getter y settters
	public int getCodigoComuna() {
		return codigoComuna;
	}

	public void setCodigoComuna(int codigoComuna) {
		this.codigoComuna = codigoComuna;
	}

	public String getNombreComuna() {
		return nombreComuna;
	}

	public void setNombreComuna(String nombreComuna) {
		this.nombreComuna = nombreComuna;
	}

	public int getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(int codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public List<Curso> getCursosEnComuna() {
		return cursosEnComuna;
	}

	public void setCursosEnComuna(List<Curso> cursosEnComuna) {
		this.cursosEnComuna = cursosEnComuna;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
}
