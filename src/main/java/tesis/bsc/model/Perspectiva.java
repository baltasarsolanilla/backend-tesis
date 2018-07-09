package tesis.bsc.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
public @Data class Perspectiva {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 
//	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estrategia_id", referencedColumnName = "id", nullable=false)
	private Estrategia estrategia;
	
	private String nombre;
	private String descripcion;
	
	public Perspectiva() { //JPA only (for Reflection)
		
	}

	public Perspectiva(Estrategia estrategia, String nombre, String descripcion) {
		this.estrategia = estrategia;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	
}