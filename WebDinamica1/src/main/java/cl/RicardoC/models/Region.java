package cl.RicardoC.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "")
public class Region {

	@Id
	@Column(name = "codigo_region")
	private int codigoRegion;
	@Column(name = "nombre")
	private String nombreRegion;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "region")
	List<Comuna> comunasEnRegion;

	//Constructor vacio
	public Region() {
		
	}

	//Getter and settters
	public int getCodigoRegion() {
		return codigoRegion;
	}

	public void setCodigoRegion(int codigoRegion) {
		this.codigoRegion = codigoRegion;
	}

	public String getNombreRegion() {
		return nombreRegion;
	}

	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	public List<Comuna> getComunasEnRegion() {
		return comunasEnRegion;
	}

	public void setComunasEnRegion(List<Comuna> comunasEnRegion) {
		this.comunasEnRegion = comunasEnRegion;
	}
	
}
