package tesis.bsc.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public @Data class Estrategia implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	private String nombre;
	private String mision;
	private String vision;
	
	public Estrategia() { //JPA ONLY
	}
	
	public Estrategia(String nombre, String mision, String vision) {
		this.nombre = nombre;
		this.mision = mision;
		this.vision = vision;
	}
}
